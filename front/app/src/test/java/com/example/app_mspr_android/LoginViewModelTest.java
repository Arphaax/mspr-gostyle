package com.example.app_mspr_android;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.app_mspr_android.model.UserModel;
import com.example.app_mspr_android.viewmodels.LoginViewModel;

import org.junit.Before;

public class LoginViewModelTest {

    private LoginViewModel loginView;
    private UserModel userModel;

    @Before
    public void setUp() {
        loginView = new LoginViewModel();
        userModel = new UserModel();

    }

    @Test
    public void getMessageRetourneObjetNull() {
        String mess = null;
        String message = loginView.getMessage();
        assertEquals(mess, message);
    }

    @Test
    public void getMessageRetourneLeStringPasséDansLeSetter() {
        loginView.setMessage("error");
        String message = loginView.getMessage();
        assertEquals("error", message);
    }

    @Test
    public void getUserNumeroRetourneNull() {
        String numero = null;
        assertEquals(numero, loginView.getUserNumero());
    }

    @Test
    public void getUserNumeroRetourneUnNumero() {
        loginView.setUserNumero("0786534586");
        assertEquals("0786534586", loginView.getUserNumero());
    }

    @Test
    public void getPassword() {
        userModel.setPassword("toto");
        String pwd = userModel.getPassword();
        loginView.setUserPassword(pwd);
        assertEquals( "toto", loginView.getUserPassword() );

    }
}

