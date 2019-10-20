package com.ccortez.desafioinfoglobo.jsonModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JSONCapa {

    @SerializedName("conteudos")
    @Expose
    private List<JSONConteudo> conteudos;

    @SerializedName("produto")
    @Expose
    private String produto;

    public List<JSONConteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(List<JSONConteudo> conteudos) {
        this.conteudos = conteudos;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}
