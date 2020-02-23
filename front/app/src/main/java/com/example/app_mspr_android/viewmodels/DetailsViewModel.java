package com.example.app_mspr_android.viewmodels;

import android.app.Activity;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.app_mspr_android.Repository.QrcodeRepository;
import com.example.app_mspr_android.model.QrcodeModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsViewModel extends BaseObservable {


    private QrcodeRepository qrcodeRepository;

    private QrcodeModel qrcodeModel;


    public DetailsViewModel() {
        qrcodeModel = new QrcodeModel();
        qrcodeRepository = new QrcodeRepository();
        GetQrcode();
    }

    @Bindable
    public QrcodeModel getQrcodeModel() {
        return qrcodeModel;
    }

    public void setQrcodeModel(QrcodeModel qrcodeModel) {
        this.qrcodeModel = qrcodeModel;
        notifyPropertyChanged(com.example.app_mspr_android.BR.qrcodeModel);
    }


    public void GetQrcode() {
        qrcodeRepository.getQrCode(1).enqueue(new Callback<QrcodeModel>() {
            @Override
            public void onResponse(Call<QrcodeModel> call, Response<QrcodeModel> response) {
                setQrcodeModel(response.body());
            }

            @Override
            public void onFailure(Call<QrcodeModel> call, Throwable t) {

            }
        });
    }


    public void onClicked(View view) {
        ((Activity) view.getContext()).finish();
    }


}
