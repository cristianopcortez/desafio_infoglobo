package com.ccortez.desafioinfoglobo.jsonModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JSONConteudo {

    @SerializedName("autores")
    @Expose
    private List<String> autores;

    @SerializedName("informePublicitario")
    @Expose
    private Boolean informePublicitario;

    @SerializedName("subTitulo")
    @Expose
    private String subTitulo;

    @SerializedName("texto")
    @Expose
    private String texto;

    @SerializedName("videos")
    @Expose
    private List<String> videos;

    @SerializedName("atualizadoEm")
    @Expose
    public String atualizadoEm;

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("publicadoEm")
    @Expose
    public String publicadoEm;

    @SerializedName("secao")
    @Expose
    public JSONSecao secao;

    @SerializedName("tipo")
    @Expose
    public String tipo;

    @SerializedName("titulo")
    @Expose
    public String titulo;

    @SerializedName("url")
    @Expose
    public String url;

    @SerializedName("urlOriginal")
    @Expose
    public String urlOriginal;

    @SerializedName("imagens")
    @Expose
    public List<JSONImagem> imagens;

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public Boolean getInformePublicitario() {
        return informePublicitario;
    }

    public void setInformePublicitario(Boolean informePublicitario) {
        this.informePublicitario = informePublicitario;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<String> getVideos() {
        return videos;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }

    public String getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(String atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublicadoEm() {
        return publicadoEm;
    }

    public void setPublicadoEm(String publicadoEm) {
        this.publicadoEm = publicadoEm;
    }

    public JSONSecao getSecao() {
        return secao;
    }

    public void setSecao(JSONSecao secao) {
        this.secao = secao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    public List<JSONImagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<JSONImagem> imagens) {
        this.imagens = imagens;
    }

    @Override
    public String toString() {
        return "JSONConteudo{" +
                "autores=" + autores +
                ", informePublicitario=" + informePublicitario +
                ", subTitulo='" + subTitulo + '\'' +
                ", texto='" + texto + '\'' +
                ", videos=" + videos +
                ", atualizadoEm='" + atualizadoEm + '\'' +
                ", id=" + id +
                ", publicadoEm='" + publicadoEm + '\'' +
                ", secao=" + secao +
                ", tipo='" + tipo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", url='" + url + '\'' +
                ", urlOriginal='" + urlOriginal + '\'' +
                ", imagens=" + imagens +
                '}';
    }
}
