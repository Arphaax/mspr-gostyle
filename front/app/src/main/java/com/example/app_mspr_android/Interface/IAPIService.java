package com.example.app_mspr_android.Interface;

import com.example.app_mspr_android.Service.APIService;

public interface IAPIService {
    APIInterface apiInterface = APIService.getApiService();
}
