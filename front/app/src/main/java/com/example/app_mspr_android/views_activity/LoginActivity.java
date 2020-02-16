package com.example.app_mspr_android.views_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.example.app_mspr_android.R;
import com.example.app_mspr_android.databinding.ActivityLoginBinding;
import com.example.app_mspr_android.viewmodels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    private static final int QRCODE_REQUEST = 1;

    @BindingAdapter({"connnexionButton"})
    public static void runMe(View view, String message) {
        if (message == LoginViewModel.SUCCESS) {
            ((Activity) view.getContext()).startActivityForResult(new Intent(view.getContext(), ActivityQRCode.class), QRCODE_REQUEST);


        }
        if(message != null && !message.isEmpty()){
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        activityLoginBinding.setUserViewModel(new LoginViewModel());
        activityLoginBinding.executePendingBindings();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == QRCODE_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                String info = data.getStringExtra("code");
                Log.v("returnCode", info); // Prints scan results
            }
        }
    }


}
