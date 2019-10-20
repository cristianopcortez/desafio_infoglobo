package com.ccortez.desafioinfoglobo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccortez.desafioinfoglobo.MainActivity;
import com.ccortez.desafioinfoglobo.R;
import com.ccortez.desafioinfoglobo.common.FormatDate;
import com.ccortez.desafioinfoglobo.jsonModel.JSONConteudo;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class NewsDetailFragment extends Fragment {

    private static final String TAG = NewsDetailFragment.class.getSimpleName();

    private Context mContext = null;
    private View view;

    Gson gson = new Gson();

    TextView tvSecaoNomeCapa;
    TextView tvTituloCapa;
    TextView tvAutorCapa;
    ImageView ivImagemCapa;
    TextView tvLegendaImagem;
    TextView tvSubTituloCapa;
    TextView tvTextoCapa;
    TextView tvDataPublicacao;
    LinearLayout llAutorCapa;

    private Fragment _currentFragment = this;

    private static final String CONTEUDO = "conteudo";

    public static NewsDetailFragment newInstance(String jsonConteudo) {
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle args = new Bundle();
        Gson gson = new Gson();
        args.putString(CONTEUDO, jsonConteudo);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_detail, container, false);

        mContext = Objects.requireNonNull(getActivity()).getApplicationContext();

        Bundle args = this.getArguments();

        Log.d(TAG, "conteudo: "+args.getString(CONTEUDO));

        Gson gson = new Gson();
        JSONConteudo jsonConteudo = gson.fromJson(
                args.getString(CONTEUDO),
                JSONConteudo.class);

        tvSecaoNomeCapa = view.findViewById(R.id.secao_nome_capa);
        tvSecaoNomeCapa.setText(jsonConteudo.getSecao().getNome().toUpperCase());
        tvAutorCapa = view.findViewById(R.id.autor_capa);
        llAutorCapa = view.findViewById(R.id.ll_autor_capa);
        tvTituloCapa = view.findViewById(R.id.titulo_capa);
        ivImagemCapa = view.findViewById(R.id.imagem_capa);
        tvLegendaImagem = view.findViewById(R.id.legenda_imagem);
        tvSubTituloCapa = view.findViewById(R.id.sub_titulo_capa);
        tvSubTituloCapa.setText(jsonConteudo.getSubTitulo());
        tvTextoCapa = view.findViewById(R.id.texto_capa);
        tvTextoCapa.setText(jsonConteudo.getTexto());
        tvDataPublicacao = view.findViewById(R.id.data_publicacao_capa);
        tvDataPublicacao.setText(
                FormatDate.getStringFromDate(
                        FormatDate.getJavaDateFromRemote(jsonConteudo.getPublicadoEm())
                        , "dd/MM/yyyy HH:mm")
        );

        tvTituloCapa.setText(jsonConteudo.getTitulo());

        if (jsonConteudo.getAutores() != null
            && jsonConteudo.getAutores().size() > 0) {
            tvAutorCapa.setText(jsonConteudo.getAutores().get(0).toUpperCase());
        } else {
            llAutorCapa.setVisibility(View.INVISIBLE);
        }


        if (jsonConteudo.getImagens().size() == 1) {
            String imgUrlPath = jsonConteudo.getImagens().get(0).getUrl();
//        Picasso.with().load(imgUrlPath).into(holder.imagem);
            Picasso.get()
                    .load(imgUrlPath)
                    .placeholder(R.drawable.ic_notif_journal_2)
                    .error(R.drawable.ic_alert)
                    .into(ivImagemCapa);
            tvLegendaImagem.setText(
                    jsonConteudo.getImagens().get(0).getLegenda()
                    + " Foto: "
                    + jsonConteudo.getImagens().get(0).getFonte()
            );
        }

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Objects.requireNonNull(getView()).setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    //go to previous fragemnt
                    //perform your fragment transaction here
                    //pass data as arguments
                    Log.v(TAG, "onBackPressed");

                    if (Objects.requireNonNull(getFragmentManager()).getBackStackEntryCount() > 0) {
                        getFragmentManager().popBackStack();
                    } else {
                        ((MainActivity) Objects.requireNonNull(getActivity())).removeFragment(_currentFragment);
                    }
                    backToNewListFragment();

                    return true;
                }
            }
            return false;
        });

    }

    private void backToNewListFragment() {
        _currentFragment = new NewsListFragment();
        ((MainActivity)getActivity()).loadFragment(_currentFragment);
    }



}
