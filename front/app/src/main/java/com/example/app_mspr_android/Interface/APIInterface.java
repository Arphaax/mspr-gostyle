package com.example.app_mspr_android.Interface;

import com.example.app_mspr_android.model.QrcodeModel;
import com.example.app_mspr_android.model.UserModel;
import com.example.app_mspr_android.model.qrcodeLabel;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {


    @POST("/api/authenticate/")
    Call<UserModel> authenticate(@Body UserModel userModel);

    @Headers("Content-Type: application/json")
    @GET("/api/users/{id}/qrcodes")
    Call<ArrayList<QrcodeModel>> getAllQrcode(@Path("id") int id);

    @Headers("Content-Type: application/json")
    @POST("/api/qrcodes/find")
    Call<QrcodeModel> getQrcodeByLabel(@Body qrcodeLabel qrcodeLabel);

    @Headers("Content-Type: application/json")
    @DELETE("/api/qrcodes/{id}")
    Call<ResponseBody> deleteByID(@Path("id") int id);





}
