package com.example.app_mspr_android.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.app_mspr_android.R;
import com.example.app_mspr_android.databinding.ActivityMainBinding;
import com.example.app_mspr_android.viewmodels.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setUserViewModel(new LoginViewModel());
        activityMainBinding.executePendingBindings();

    }
}
