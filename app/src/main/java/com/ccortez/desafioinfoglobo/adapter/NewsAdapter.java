package com.ccortez.desafioinfoglobo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ccortez.desafioinfoglobo.R;
import com.ccortez.desafioinfoglobo.common.FormatDate;
import com.ccortez.desafioinfoglobo.jsonModel.JSONConteudo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter {
    private List<JSONConteudo> news_list;
    private EventIMPL impl;
    private Context mContext = null;

    public NewsAdapter(List<JSONConteudo> news_list, EventIMPL impl,
                       Context mContext){
        this.news_list = news_list;
        this.impl = impl;
        this.mContext = mContext;
    }

    @Override
    public int getItemCount() {
        return news_list.size();

    }

// @Override
// public int getItemViewType(int position) {
// if (position==0) {
// return 0;
// }else{
// return 1;
// }
// }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                      int viewType) {

        View itemView;


        itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder,
                                 int position) {


        NewsViewHolder holder = (NewsViewHolder) viewHolder;

        holder.itemView.setOnClickListener(v -> {
            impl.selecionarMateria(news_list.get(
                    viewHolder.getAdapterPosition()),
                    viewHolder.getAdapterPosition());
            notifyDataSetChanged();
        });

        JSONConteudo conteudo = news_list.get(viewHolder.getAdapterPosition());

        FormatDate formatDate = new FormatDate();

        holder.secao_nome.setText(conteudo.getSecao().getNome().toUpperCase());
        holder.titulo.setText(String.valueOf(conteudo.getTitulo()));

        if (conteudo.getImagens().size() == 1) {
            String imgUrlPath = conteudo.getImagens().get(0).getUrl();
//        Picasso.with().load(imgUrlPath).into(holder.imagem);
            Picasso.get()
                    .load(imgUrlPath)
                    .placeholder(R.drawable.ic_notif_journal_2)
                    .error(R.drawable.ic_alert)
                    .into(holder.imagem);
        }

    }
    public class NewsViewHolder extends RecyclerView.ViewHolder {
        final TextView secao_nome;
        final TextView titulo;
        final ImageView imagem;


        NewsViewHolder(View view){
            super(view);
            secao_nome = view.findViewById(R.id.secao_nome);
            titulo = view.findViewById(R.id.titulo);
            imagem = view.findViewById(R.id.imagem);

        }
    }
    public interface EventIMPL{
        void selecionarMateria(JSONConteudo conteudo, int position);
    }


}
