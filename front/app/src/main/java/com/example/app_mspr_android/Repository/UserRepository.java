package com.example.app_mspr_android.Repository;

import com.example.app_mspr_android.Interface.APIInterface;
import com.example.app_mspr_android.model.UserModel;

public class UserRepository {

    private APIInterface apiInterface;

    public UserRepository(UserModel userModel) {
        apiInterface.authenticate(userModel);
    }
}
