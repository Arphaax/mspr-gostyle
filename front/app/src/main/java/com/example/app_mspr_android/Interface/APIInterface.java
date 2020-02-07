package com.example.app_mspr_android.Interface;

import com.example.app_mspr_android.model.Token;
import com.example.app_mspr_android.model.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {


    @POST("api/user/authenticate")
    Call<Token> authenticate(@Body UserModel userModel);

}
