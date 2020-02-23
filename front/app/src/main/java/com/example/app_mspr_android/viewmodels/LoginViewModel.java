package com.example.app_mspr_android.viewmodels;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.app_mspr_android.Repository.UserRepository;
import com.example.app_mspr_android.model.UserModel;
import com.example.app_mspr_android.views_activity.AccueilActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginViewModel extends BaseObservable {

    private static final String SUCCESS = "Connexion établis !";
    private static final String WRONG_CREDENTIALS = "Erreur dans le login ou le mot de passe";
    private static final String INTERNAL_ERROR = "Une erreur interne est survenue";

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


    public void onClicked(final View view) {

        userRepository.authenticate(userModel).enqueue((new Callback<UserModel>() {
                @Override
                public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                    switch (response.code()) {
                        case 200:

                            setMessage(SUCCESS);

                            UserModel userModel = response.body();
                            String authHeader = response.headers().get("Authorization");
                            userModel.setToken(authHeader);
                            userModel.setPassword(null);

                            Intent intent = new Intent(view.getContext(), AccueilActivity.class);
                            intent.putExtra("userInfo", userModel);

                            view.getContext().startActivity(intent);
                            ((Activity) view.getContext()).finish();

                            break;

                        case 403:
                            setMessage(WRONG_CREDENTIALS);
                            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            setMessage(INTERNAL_ERROR);
                            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
                            break;
                    }


                }

                @Override
                public void onFailure(Call<UserModel> call, Throwable t) {
                    setMessage(INTERNAL_ERROR);
                }
            }));
        }


}
