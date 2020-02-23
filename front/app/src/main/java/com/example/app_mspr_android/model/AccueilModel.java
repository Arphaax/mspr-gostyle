package com.example.app_mspr_android.model;

import java.util.ArrayList;

public class AccueilModel {

    ArrayList<QrcodeModel> qrcodeModelList;

    public AccueilModel() {

        qrcodeModelList = new ArrayList<QrcodeModel>() {
        };

    }


    public ArrayList<QrcodeModel> getQrcodeModelList() {
        return qrcodeModelList;
    }

    public void setQrcodeModelList(ArrayList<QrcodeModel> qrcodeModelList) {
        this.qrcodeModelList = qrcodeModelList;
    }
}
