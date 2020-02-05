package com.example.app_mspr_android.viewmodels;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.app_mspr_android.BR;
import com.example.app_mspr_android.BR.*;
import com.example.app_mspr_android.model.UserModel;




public class LoginViewModel extends BaseObservable {

    private UserModel userModel;

    public LoginViewModel(){
        userModel= new UserModel();
    }

    @Bindable
    public String getUserEmail(){
        return userModel.getEmail();
    }

    public void setUserEmail(String email){
        userModel.setEmail(email);
        notifyPropertyChanged(com.example.app_mspr_android.BR.userEmail);
    }

    @Bindable
    public String getUserPassword(){
        return userModel.getPassword();
    }

    public void setUserPassword(String passwd){
        userModel.setEmail(passwd);
        notifyPropertyChanged(com.example.app_mspr_android.BR.userPassword);
    }
}
