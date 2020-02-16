package com.example.app_mspr_android.Service;

import com.example.app_mspr_android.Interface.APIInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {


    private static final String BASE_URL = "http://10.0.2.2:8080/mspr_gostyle_api/";
    private static Retrofit retrofit = new retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private static APIInterface client;

    public static APIInterface getApiService() {
        client = retrofit.create(APIInterface.class);
        return client;
    }


}
