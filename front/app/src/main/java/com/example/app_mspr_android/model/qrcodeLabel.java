package com.example.app_mspr_android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class qrcodeLabel {


    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("libelle")
    @Expose
    private String libelle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
