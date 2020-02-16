package com.example.app_mspr_android.viewmodels;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.app_mspr_android.Interface.APIInterface;
import com.example.app_mspr_android.Repository.UserRepository;
import com.example.app_mspr_android.Service.APIService;
import com.example.app_mspr_android.model.Token;
import com.example.app_mspr_android.model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginViewModel extends BaseObservable {

    public static final String SUCCESS = "SUCCESS_CONNEXION";

    private UserModel userModel;
    private UserRepository userRepository;

    @Bindable
    private String message;

    public LoginViewModel() {

        userModel = new UserModel();
        userRepository= new UserRepository();


    }

    @Bindable
    public String getMessage() {
        return message;
    }

    public void setMessage(String Message) {
        this.message = Message;
        notifyPropertyChanged(com.example.app_mspr_android.BR.message);
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
        try {
            Call call = userRepository.authenticate(userModel);
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {

                }

                @Override
                public void onFailure(Call call, Throwable t) {

                }
            });
        }
        catch (Exception e){
            Log.v("INFORM", e.getMessage().toString()); // Prints scan results
        }


    }
}
