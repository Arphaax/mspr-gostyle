package com.example.app_mspr_android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("numero")
    @Expose
    private String numero;

    @SerializedName("password")
    @Expose
    private String password;

    public UserModel(String email, String password) {
        this.numero = email;
        this.password = password;
    }

    public UserModel() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String email) {
        this.numero = email;
    }
}
