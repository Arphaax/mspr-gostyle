package com.example.app_mspr_android.viewmodels;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

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
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccueilViewModel extends BaseObservable {


    private static final String INTERNAL_ERROR = "Une erreur interne est survenue";
    private static final String CODE_INNEXISTANT = "Ce code n'existe pas";
    private static final String CODE_ALREADY_EXIST = "Ce code existe déja";
    public static final int QRCODE_REQUEST = 1;
    public static final int DETAILS_REQUEST = 2;


    public MutableLiveData<ArrayList<QrcodeModel>> mutableLiveData;
    private AccueilModel accueilModel;
    private QrcodeRepository qrcodeRepository;
    private UserModel userModel;
    private View view;


    public AccueilViewModel(UserModel userModel, View root) {
        accueilModel = new AccueilModel();
        qrcodeRepository = new QrcodeRepository();
        this.userModel = userModel;
        view = root;
        mutableLiveData = new MutableLiveData<>();

        GetAllQrCode();
    }


    @Bindable
    public UserModel getUserModel() {
        return userModel;
    }


    @Bindable
    public ArrayList<QrcodeModel> getListQrCode() {
        return accueilModel.getQrcodeModelList();
    }

    private void setListQrCode(ArrayList<QrcodeModel> qrCode) {
        accueilModel.setQrcodeModelList(qrCode);
        notifyPropertyChanged(com.example.app_mspr_android.BR.listQrCode);
    }


    public void GetQrCodeByCode(String id) {

        qrcodeRepository.getQrCodeByLabel(id).enqueue((new Callback<QrcodeModel>() {
            @Override
            public void onResponse(Call<QrcodeModel> call, Response<QrcodeModel> response) {

                switch (response.code()) {
                    case 200:

                            addQrcodeIfNotExist(response.body());
                        break;
                    case 404:
                        Toast.makeText(view.getContext(), CODE_INNEXISTANT, Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        Toast.makeText(view.getContext(), INTERNAL_ERROR, Toast.LENGTH_SHORT).show();
                        break;
                }

            }

            @Override
            public void onFailure(Call<QrcodeModel> call, Throwable t) {
                Toast.makeText(view.getContext(), INTERNAL_ERROR, Toast.LENGTH_SHORT).show();
            }
        }));

    }

    public boolean checkIfExistInQrCodeList(QrcodeModel qrcodeModel){
        for (Object o : accueilModel.getQrcodeModelList()) {
            // use utility function from java.util to deal with nulls
            if (Objects.equals(o, qrcodeModel)) {
                return true;

            }
        }
        return false;


    }

    public void addQrcodeIfNotExist(QrcodeModel qrcodeModel){
        boolean test = checkIfExistInQrCodeList(qrcodeModel);
        if(checkIfExistInQrCodeList(qrcodeModel)){
            Toast.makeText(view.getContext(), CODE_ALREADY_EXIST, Toast.LENGTH_SHORT).show();
        }
        else
        {
            accueilModel.getQrcodeModelList().add(qrcodeModel);
            mutableLiveData.setValue(getListQrCode());
        }
    }


    public void GetAllQrCode() {


        qrcodeRepository.getAllQrCode(userModel.getId()).enqueue((new Callback<ArrayList<QrcodeModel>>() {
            @Override
            public void onResponse(Call<ArrayList<QrcodeModel>> call, Response<ArrayList<QrcodeModel>> response) {
                switch (response.code()) {
                    case 200:
                        setListQrCode(response.body());
                        mutableLiveData.setValue(getListQrCode());
                        break;

                    default:
                        Toast.makeText(view.getContext(), INTERNAL_ERROR, Toast.LENGTH_SHORT).show();
                        break;
                }

            }

            @Override
            public void onFailure(Call<ArrayList<QrcodeModel>> call, Throwable t) {
                Toast.makeText(view.getContext(), INTERNAL_ERROR, Toast.LENGTH_SHORT).show();
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
