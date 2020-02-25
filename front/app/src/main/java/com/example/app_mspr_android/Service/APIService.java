package com.example.app_mspr_android.Service;

import com.example.app_mspr_android.Interface.APIInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {


    private static final String BASE_URL = "http://192.168.43.159:8080/";
    private static Retrofit retrofit = new retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static APIInterface getApiService() {
        return retrofit.create(APIInterface.class);
    }


}
