package com.example.app_mspr_android.Interface;

import com.example.app_mspr_android.model.QrcodeModel;
import com.example.app_mspr_android.model.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {


    @POST("api/authenticate/")
    Call<UserModel> authenticate(@Body UserModel userModel);

    @Headers("Content-Type: application/json")
    @GET("/api/users/{id}/qrcodes")
    Call<ArrayList<QrcodeModel>> getAllQrcode(@Path("id") int id);

    @Headers("Content-Type: application/json")
    @GET("/api/qrcodes/{location}")
    Call<QrcodeModel> getQrcodeByLabel(@Path("location") String location);

    @Headers("Content-Type: application/json")
    @GET("/api/qrcodes/{location}")
    Call<QrcodeModel> getQrcodeById(@Path("location") int location);





}
