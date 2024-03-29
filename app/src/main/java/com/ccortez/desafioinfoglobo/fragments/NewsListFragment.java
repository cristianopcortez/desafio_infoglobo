package com.ccortez.desafioinfoglobo.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ccortez.desafioinfoglobo.MainActivity;
import com.ccortez.desafioinfoglobo.R;
import com.ccortez.desafioinfoglobo.adapter.NewsAdapter;
import com.ccortez.desafioinfoglobo.jsonModel.JSONCapa;
import com.ccortez.desafioinfoglobo.jsonModel.JSONConteudo;
import com.ccortez.desafioinfoglobo.jsonModel.JSONRoot;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class NewsListFragment extends Fragment
        implements NewsAdapter.EventIMPL {

    private static final String TAG = NewsListFragment.class.getSimpleName();

    RecyclerView recyclerView;
    private View view;
    private Context mContext = null;

    List<JSONConteudo> listaNoticias;
    JSONConteudo jsonMateriaCapa;

    Gson gson = new Gson();

    TextView tvSecaoNomeCapa;
    TextView tvTituloCapa;
    ImageView ivImagemCapa;
    RelativeLayout rlMateriaPrincipalCapa;

    public NewsListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_list, container, false);

        mContext = Objects.requireNonNull(getActivity()).getApplicationContext();

        Type collectionType = new TypeToken<Collection<JSONObject>>(){}.getType();
//        Log.d(TAG, "json carregado: "+ loadJSONFromAsset(mContext, "capa.json"));

        JSONCapa[] listaCapa = gson.fromJson(loadJSONFromAsset(mContext, "capa.json"), JSONCapa[].class);

        listaNoticias = listaCapa[0].getConteudos();
        jsonMateriaCapa = listaCapa[0].getConteudos().get(0);

        tvSecaoNomeCapa = view.findViewById(R.id.secao_nome_capa);
        tvTituloCapa = view.findViewById(R.id.titulo_capa);
        ivImagemCapa = view.findViewById(R.id.imagem_capa);
        rlMateriaPrincipalCapa = view.findViewById(R.id.rl_materia_principal_capa);
        rlMateriaPrincipalCapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selecionarMateria(jsonMateriaCapa, 0);
            }
        });

        setCapa(listaNoticias.get(0));
        listaNoticias.remove(0);
        setRecyclerView();

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void selecionarMateria(JSONConteudo conteudo, int position) {
        // abrir Fragment de detalhe matéria

        Gson gson = new Gson();

        Log.d(TAG, "=== matéria clicada: "+gson.toJson(conteudo));

        ((MainActivity) getActivity()).removeFragment(this);
        NewsDetailFragment newsDetailFragment =
                NewsDetailFragment.newInstance(gson.toJson(conteudo));
        ((MainActivity) getActivity()).loadFragment(newsDetailFragment);
    }

    public void setCapa(JSONConteudo conteudo) {
        tvSecaoNomeCapa.setText(conteudo.getSecao().getNome().toUpperCase());
        tvTituloCapa.setText(conteudo.getTitulo());

        if (conteudo.getImagens().size() == 1) {
            String imgUrlPath = conteudo.getImagens().get(0).getUrl();
//        Picasso.with().load(imgUrlPath).into(holder.imagem);
            Picasso.get()
                    .load(imgUrlPath)
                    .placeholder(R.drawable.ic_notif_journal_2)
                    .error(R.drawable.ic_alert)
                    .into(ivImagemCapa);
        }
    }

    public void setRecyclerView(){
        recyclerView = view.findViewById(R.id.lista);
        recyclerView.setAdapter(new NewsAdapter(listaNoticias,
                NewsListFragment.this, mContext));
        RecyclerView.LayoutManager layout =
                new LinearLayoutManager(view.getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);

        Log.d(TAG, "====== Lista notícias");
        if (listaNoticias != null) {
            for (JSONConteudo noticia : listaNoticias) {
                Log.d(TAG, "====== Titulo: " + noticia.getTitulo());
//                Log.d(TAG, "====== Codigo Agendamento: " + listaEvento.getCodigo_agendamento_evento());
//                Log.d(TAG, "====== Data: " + FormatDate.getStringFromDate(FormatDate.getJavaDateFromRemote(listaEvento.getData_evento())));
            }
        } else {
            Log.d(TAG, "========= Sem noticias !!!!!!!!!!!!!!");
            Toast.makeText(getActivity(),"Sem noticias", Toast.LENGTH_LONG).show();
        }
    }

    public String loadJSONFromAsset(Context context, String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;

    }
}
