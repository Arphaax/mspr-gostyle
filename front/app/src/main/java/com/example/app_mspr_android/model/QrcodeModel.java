package com.example.app_mspr_android.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QrcodeModel {

    @SerializedName("ID")
    @Expose
    private int ID;
    @SerializedName("libelle")
    @Expose
    private String libelle;
    @SerializedName("montant")
    @Expose
    private int montant;

    public QrcodeModel(int i, String string, int j) {

        ID = i;
        libelle = string;
        montant = j;
    }


    public QrcodeModel() {
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public int getID() {
        return ID;
    }
}
