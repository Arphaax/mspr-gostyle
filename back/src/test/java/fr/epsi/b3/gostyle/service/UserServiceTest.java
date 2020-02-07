package fr.epsi.b3.gostyle.service;

import fr.epsi.b3.gostyle.dao.UserDao;
<<<<<<< HEAD
import fr.epsi.b3.gostyle.exception.QrcodeNotFoundException;
import fr.epsi.b3.gostyle.exception.UserNotFoundException;
import fr.epsi.b3.gostyle.model.Qrcode;
=======
import fr.epsi.b3.gostyle.exception.UserNotFoundException;
>>>>>>> Api/gostyle006 Skeleton update authenticate method
import fr.epsi.b3.gostyle.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UserServiceTest {
    private UserService userService;

    @Before
    public void init() {
        userService = Mockito.mock(UserService.class);
    }

    @Test
    public void getByIdRetourneUnUtilisateur() throws Exception {
        User user = new User(1,
                "toto",
                "toto",
                0600000000,
                "toto_password");
        Mockito.when(userService.getById(user.getId())).thenReturn(user);

        User result = userService.getById(1);

        assertEquals(result, user);
    }

    @Test
    public void getAllQrCodesOfUserRetourneLaListeDesQrCodesDUnUtilisateur() throws Exception {
        User user = new User(1,
                "toto",
                "toto",
                0600000000,
                "toto_password");

        Qrcode qrcode1 = new Qrcode(1, "reduction", 15);
        Qrcode qrcode2 = new Qrcode(2, "reduction panier", 20);
        List<Qrcode> qrcodes = new ArrayList<>();
        qrcodes.add(qrcode1);
        qrcodes.add(qrcode2);

        Mockito.when(userService.getAllQrCodesOfUser(user.getId())).thenReturn(qrcodes);

        List<Qrcode> result = userService.getAllQrCodesOfUser(1);

        assertEquals(result, qrcodes);
    }

    @Test(expected= UserNotFoundException.class)
    public void tentativeRecuperationDUnUserQuiNExistePas() throws Exception {
        Integer id = 78;
        Mockito.when(userService.getById(id)).thenThrow(UserNotFoundException.class);

        User user = userService.getById(id);

        fail("UserNotFoundException expected");
    }
}
