package com.example.app_mspr_android.views_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.example.app_mspr_android.R;
import com.example.app_mspr_android.databinding.ActivityLoginBinding;
import com.example.app_mspr_android.viewmodels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    @BindingAdapter({"connnexionButton"})
    public static void runMe(View view, String message) {
        if (message == (LoginViewModel.SUCCESS)) {
            view.getContext().startActivity(new Intent(view.getContext(), ActivityQRCode.class));

            //((Activity) view.getContext()).finish();
        } else {
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        activityLoginBinding.setUserViewModel(new LoginViewModel());
        activityLoginBinding.executePendingBindings();


    }


}
