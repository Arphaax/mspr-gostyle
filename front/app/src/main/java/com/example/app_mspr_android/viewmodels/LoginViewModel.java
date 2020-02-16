package com.example.app_mspr_android.viewmodels;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.app_mspr_android.BR;
import com.example.app_mspr_android.Interface.APIInterface;
import com.example.app_mspr_android.Repository.UserRepository;
import com.example.app_mspr_android.Service.APIService;
import com.example.app_mspr_android.model.Token;
import com.example.app_mspr_android.model.UserModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginViewModel extends BaseObservable {

    public static final String SUCCESS = "SUCCESS_CONNEXION";
    public static final String FALSE = "WRONG CREDENTIALS";

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
    public String getUserNumero(){
        return userModel.getNumero();
    }

    public void setUserNumero(String numero){
        userModel.setNumero(numero);
        notifyPropertyChanged(com.example.app_mspr_android.BR.userNumero);
    }

    @Bindable
    public String getUserPassword(){
        return userModel.getPassword();
    }

    public void setUserPassword(String passwd){
        userModel.setPassword(passwd);
        notifyPropertyChanged(com.example.app_mspr_android.BR.userPassword);
    }



    public void onClicked() {
        try {
            userRepository.authenticate(userModel).enqueue((new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                }

                @Override
                public void onFailure(Call<ResponseBody>  call, Throwable t) {

                }
            }));
        }
        catch (Exception e){
            Log.v("INFORM", e.getMessage().toString()); // Prints scan results
        }


    }
}
