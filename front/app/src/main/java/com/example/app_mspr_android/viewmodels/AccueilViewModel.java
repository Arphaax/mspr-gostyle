package com.example.app_mspr_android.viewmodels;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;

import com.example.app_mspr_android.Repository.QrcodeRepository;
import com.example.app_mspr_android.model.AccueilModel;
import com.example.app_mspr_android.model.QrcodeModel;
import com.example.app_mspr_android.model.UserModel;
import com.example.app_mspr_android.views_activity.ActivityQRCode;
import com.example.app_mspr_android.views_activity.LoginActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccueilViewModel extends BaseObservable {

    public static final int QRCODE_REQUEST = 1;
    private static final String CAN_EXECUTE = "Deconnexion";
    public MutableLiveData<ArrayList<QrcodeModel>> mutableLiveData = new MutableLiveData<>();
    private AccueilModel accueilModel;
    private QrcodeRepository qrcodeRepository;
    private UserModel userModel;
    @Bindable
    private String message;


    public AccueilViewModel(UserModel userModel) {
        accueilModel = new AccueilModel();
        qrcodeRepository = new QrcodeRepository();
        this.userModel = userModel;

        GetAllQrCode();
    }

    @Bindable
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Bindable
    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    @Bindable
    public ArrayList<QrcodeModel> getListQrCode() {
        return accueilModel.getQrcodeModelList();
    }

    private void setListQrCode(ArrayList<QrcodeModel> qrCode) {
        accueilModel.setQrcodeModelList(qrCode);
        notifyPropertyChanged(com.example.app_mspr_android.BR.listQrCode);
    }


    public void addQrcodeInList(QrcodeModel qrCode) {
        // accueilModel.getQrcodeModelList().add(qrCode);
        notifyPropertyChanged(com.example.app_mspr_android.BR.listQrCode);
    }


    private void GetAllQrCode() {


        qrcodeRepository.getAllQrCode(userModel.getId()).enqueue((new Callback<ArrayList<QrcodeModel>>() {
            @Override
            public void onResponse(Call<ArrayList<QrcodeModel>> call, Response<ArrayList<QrcodeModel>> response) {
                setListQrCode(response.body());
                ArrayList<QrcodeModel> test = getListQrCode();
                mutableLiveData.setValue(test);
            }

            @Override
            public void onFailure(Call<ArrayList<QrcodeModel>> call, Throwable t) {

            }
        }));

    }


    public void scannerButtonClick(View view) {
        ((Activity) view.getContext()).startActivityForResult(new Intent(view.getContext(), ActivityQRCode.class), QRCODE_REQUEST);
    }

    public void buttonDeconnexionClick(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), LoginActivity.class));
        ((Activity) view.getContext()).finish();
    }


}
