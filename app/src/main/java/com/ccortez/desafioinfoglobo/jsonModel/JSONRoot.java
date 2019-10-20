package com.ccortez.desafioinfoglobo.jsonModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.List;

public class JSONRoot {

//    @SerializedName("conteudos")
    @Expose
    private List<JSONCapa> rootList;

    public List<JSONCapa> getRootList() {
        return rootList;
    }

    public void setRootList(List<JSONCapa> rootList) {
        this.rootList = rootList;
    }
}
