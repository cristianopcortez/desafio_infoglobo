package com.ccortez.desafioinfoglobo.jsonModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONSecao {

    @SerializedName("nome")
    @Expose
    public String nome;

    @SerializedName("url")
    @Expose
    public String url;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
