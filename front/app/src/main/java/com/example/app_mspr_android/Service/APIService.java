package com.example.app_mspr_android.Service;

import com.example.app_mspr_android.Interface.APIInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {


    private static final String BASE_URL = "https://localhost:8080/";
    private static Retrofit retrofit;
    private static APIInterface client;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }


}