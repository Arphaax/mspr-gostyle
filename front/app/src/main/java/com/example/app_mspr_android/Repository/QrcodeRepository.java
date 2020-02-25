package com.example.app_mspr_android.Repository;

import com.example.app_mspr_android.Interface.IAPIService;
import com.example.app_mspr_android.model.QrcodeModel;
import com.example.app_mspr_android.model.qrcodeLabel;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class QrcodeRepository implements IAPIService {

    public Call<ArrayList<QrcodeModel>> getAllQrCode(int id) {
        return apiInterface.getAllQrcode(id);
    }

    public Call<QrcodeModel> getQrCodeByLabel(qrcodeLabel label) {
        return apiInterface.getQrcodeByLabel(label);
    }

    public Call<ResponseBody> deleteByID(int id) {
        return apiInterface.deleteByID(id);
    }
}
