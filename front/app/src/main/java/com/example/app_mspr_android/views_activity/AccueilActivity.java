package com.example.app_mspr_android.views_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import com.example.app_mspr_android.R;
import com.example.app_mspr_android.adapter.QrcodeAdapter;
import com.example.app_mspr_android.databinding.ActivityAccueilBinding;
import com.example.app_mspr_android.model.QrcodeModel;
import com.example.app_mspr_android.model.UserModel;
import com.example.app_mspr_android.viewmodels.AccueilViewModel;

import java.util.ArrayList;

public class AccueilActivity extends AppCompatActivity {


    private AccueilViewModel accueilViewModel;
    private QrcodeAdapter qrcodeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserModel userModel = (UserModel) getIntent().getSerializableExtra("userInfo");


        ActivityAccueilBinding activityAccueilBinding = DataBindingUtil.setContentView(this, R.layout.activity_accueil);
        accueilViewModel = new AccueilViewModel(userModel, activityAccueilBinding.getRoot());
        activityAccueilBinding.setAccueilVm(accueilViewModel);
        qrcodeAdapter = new QrcodeAdapter(this, accueilViewModel.getListQrCode());
        activityAccueilBinding.listView.setAdapter(qrcodeAdapter);
        activityAccueilBinding.executePendingBindings();

        accueilViewModel.mutableLiveData.observe(this, new Observer<ArrayList<QrcodeModel>>() {
            @Override
            public void onChanged(ArrayList<QrcodeModel> qrcodeModelArrayList) {
                qrcodeAdapter.clear();
                qrcodeAdapter.addAll(accueilViewModel.getListQrCode());
                qrcodeAdapter.notifyDataSetChanged();

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case AccueilViewModel.QRCODE_REQUEST:
                if (resultCode == Activity.RESULT_OK) {
                    String info = data.getStringExtra("code");
                    accueilViewModel.GetQrCodeByCode(info);
                }
                break;
            case AccueilViewModel.DETAILS_REQUEST:
                if(resultCode == Activity.RESULT_OK){
                    accueilViewModel.GetAllQrCode();
                }
        }

    }


}
