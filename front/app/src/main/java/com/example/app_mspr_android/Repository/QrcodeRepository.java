package com.example.app_mspr_android.Repository;

import com.example.app_mspr_android.Interface.IAPIService;
import com.example.app_mspr_android.model.QrcodeModel;

import java.util.ArrayList;

import retrofit2.Call;

public class QrcodeRepository implements IAPIService {

    public Call<ArrayList<QrcodeModel>> getAllQrCode(int id) {
        return apiInterface.getAllQrcode(id);
    }

    public Call<QrcodeModel> getQrCodeByLabel(String id) {
        return apiInterface.getQrcodeByLabel(id);
    }
}
