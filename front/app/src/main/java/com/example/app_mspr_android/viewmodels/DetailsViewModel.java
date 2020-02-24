package com.example.app_mspr_android.viewmodels;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.app_mspr_android.Repository.QrcodeRepository;
import com.example.app_mspr_android.model.QrcodeModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsViewModel extends BaseObservable {

    private static final String INTERNAL_ERROR = "Une erreur interne est survenue";
    private static final String CODE_INNEXISTANT = "Ce code n'existe pas";

    private QrcodeRepository qrcodeRepository;
    private QrcodeModel qrcodeModel;
    private View view;


    public DetailsViewModel(QrcodeModel qrcodeModel, View root) {
        this.qrcodeModel = qrcodeModel;
        qrcodeRepository = new QrcodeRepository();
        view = root;

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
        qrcodeRepository.deleteByID(Integer.parseInt(qrcodeModel.getId())).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                switch (response.code()){
                    case 200:
                        ((Activity) view.getContext()).setResult(Activity.RESULT_OK);
                        ((Activity) view.getContext()).finish();

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
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(view.getContext(), CODE_INNEXISTANT, Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void onClicked(View view) {
        ((Activity) view.getContext()).finish();

    }


}
