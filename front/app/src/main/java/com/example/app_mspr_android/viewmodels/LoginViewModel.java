package com.example.app_mspr_android.viewmodels;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.app_mspr_android.BR;
import com.example.app_mspr_android.BR.*;
import com.example.app_mspr_android.model.UserModel;




public class LoginViewModel extends BaseObservable {

    private UserModel userModel;

    @Bindable
    private String toastMessage = null;
    private String success = "you're in Mspr GoStyle";

    @Bindable
    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(com.example.app_mspr_android.BR.toastMessage);
    }

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
        userModel.setPassword(passwd);
        notifyPropertyChanged(com.example.app_mspr_android.BR.userPassword);
    }

    public boolean isInputDataValid() {
        return TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;
    }

    public void onClicked() {
        setToastMessage(success);
    }
}
