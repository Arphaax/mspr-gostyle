package com.example.app_mspr_android.Repository;

import com.example.app_mspr_android.Interface.IAPIService;
import com.example.app_mspr_android.model.UserModel;

import retrofit2.Call;

public class UserRepository implements IAPIService {

    public Call<UserModel> authenticate(UserModel userModel) {
       return apiInterface.authenticate(userModel);
    }
}
