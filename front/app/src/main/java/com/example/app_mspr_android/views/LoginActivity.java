package com.example.app_mspr_android.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
            view.getContext().startActivity(new Intent(view.getContext(), Activity2.class));
            ((Activity) view.getContext()).finish();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        activityLoginBinding.setUserViewModel(new LoginViewModel());
        activityLoginBinding.executePendingBindings();


    }

    private void test() {

    }
}
