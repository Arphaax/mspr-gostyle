package com.example.app_mspr_android.views_activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.app_mspr_android.R;
import com.example.app_mspr_android.databinding.ActivityLoginBinding;
import com.example.app_mspr_android.viewmodels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        activityLoginBinding.setUserViewModel(new LoginViewModel());
        activityLoginBinding.executePendingBindings();


    }


}
