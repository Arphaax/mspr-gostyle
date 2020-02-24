package com.example.app_mspr_android.views_activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.app_mspr_android.R;
import com.example.app_mspr_android.databinding.ActivityDetailsAvtivityBinding;
import com.example.app_mspr_android.model.QrcodeModel;
import com.example.app_mspr_android.viewmodels.DetailsViewModel;

public class DetailsAvtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QrcodeModel qrcodeModel = (QrcodeModel) getIntent().getSerializableExtra("qrCodeInfo");
        ActivityDetailsAvtivityBinding activityDetailsAvtivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_details_avtivity);
        activityDetailsAvtivityBinding.setDetailsvm(new DetailsViewModel(qrcodeModel));
        activityDetailsAvtivityBinding.executePendingBindings();

    }
}
