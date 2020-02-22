package com.example.app_mspr_android.Repository;

import com.example.app_mspr_android.Interface.APIInterface;
import com.example.app_mspr_android.Service.APIService;
import com.example.app_mspr_android.model.UserModel;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class UserRepository {

    private APIInterface apiInterface;

    public UserRepository() {

        apiInterface= APIService.getApiService();
    }

    public Call<ResponseBody> authenticate(UserModel userModel) {
       return apiInterface.authenticate(userModel);

    }
}
