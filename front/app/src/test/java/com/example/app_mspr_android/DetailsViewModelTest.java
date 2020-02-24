package com.example.app_mspr_android;

import android.view.View;
import android.widget.Button;

import com.example.app_mspr_android.model.QrcodeModel;
import com.example.app_mspr_android.model.UserModel;
import com.example.app_mspr_android.viewmodels.DetailsViewModel;
import com.example.app_mspr_android.viewmodels.LoginViewModel;

import org.junit.Before;
import org.mockito.Mock;

public class DetailsViewModelTest {

    private DetailsViewModel detailsViewModel;
    @Mock
    private Button mockButton;
    @Mock
    private QrcodeModel qrcodeModel;
    @Mock
    private View view;

    @Before
    public void setUp() {
        detailsViewModel = new DetailsViewModel(qrcodeModel, view);


    }

    public void onCreate() {

    }
}
