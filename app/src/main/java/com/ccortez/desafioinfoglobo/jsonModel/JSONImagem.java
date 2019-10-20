package com.ccortez.desafioinfoglobo.jsonModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONImagem {

    @SerializedName("autor")
    @Expose
    public String autor;

    @SerializedName("fonte")
    @Expose
    public String fonte;

    @SerializedName("legenda")
    @Expose
    public String legenda;

    @SerializedName("url")
    @Expose
    public String url;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
