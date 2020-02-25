package com.example.app_mspr_android.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.app_mspr_android.R;
import com.example.app_mspr_android.databinding.BtnListBinding;
import com.example.app_mspr_android.model.QrcodeModel;
import com.example.app_mspr_android.viewmodels.AccueilViewModel;
import com.example.app_mspr_android.views_activity.DetailsAvtivity;

import java.util.ArrayList;

public class QrcodeAdapter extends ArrayAdapter<QrcodeModel> {

    private ArrayList<QrcodeModel> qrcodeModelArrayList;
    private Context context;

    public QrcodeAdapter(@NonNull Context context, ArrayList<QrcodeModel> qrcodeModelArrayList) {
        super(context, R.layout.btn_list, qrcodeModelArrayList);
        this.qrcodeModelArrayList = qrcodeModelArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        BtnListBinding btnListBinding = DataBindingUtil.inflate(layoutInflater, R.layout.btn_list, parent, false);
        btnListBinding.setQrcodeList(qrcodeModelArrayList.get(position));
        btnListBinding.getRoot().findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QrcodeModel item = qrcodeModelArrayList.get(position);
                Intent intent = new Intent(v.getContext(), DetailsAvtivity.class);
                intent.putExtra("qrCodeInfo", item);
                ((Activity)v.getContext()).startActivityForResult(intent, AccueilViewModel.DETAILS_REQUEST);


            }
        });

        return btnListBinding.getRoot();
    }

}
