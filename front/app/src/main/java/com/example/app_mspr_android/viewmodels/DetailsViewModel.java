package com.example.app_mspr_android.viewmodels;

import android.app.Activity;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.app_mspr_android.Repository.QrcodeRepository;
import com.example.app_mspr_android.model.QrcodeModel;

public class DetailsViewModel extends BaseObservable {


    private QrcodeRepository qrcodeRepository;

    private QrcodeModel qrcodeModel;


    public DetailsViewModel(QrcodeModel qrcodeModel) {
        this.qrcodeModel = qrcodeModel;
        qrcodeRepository = new QrcodeRepository();

    }

    @Bindable
    public QrcodeModel getQrcodeModel() {
        return qrcodeModel;
    }

    public void setQrcodeModel(QrcodeModel qrcodeModel) {
        this.qrcodeModel = qrcodeModel;
        notifyPropertyChanged(com.example.app_mspr_android.BR.qrcodeModel);
    }


    public void deleteQrCode() {

    }


    public void onClicked(View view) {
        ((Activity) view.getContext()).finish();

    }


}
