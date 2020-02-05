package fr.epsi.b3.gostyle.service;

import fr.epsi.b3.gostyle.dao.UserDao;
import fr.epsi.b3.gostyle.model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    private UserDao userDao;
    private UserService userService;

    @Before
    public void init() {
        userDao = mock(UserDao.class);
        userService = new UserService();
    }

    @Test
    public void getByIdRetourneUnUtilisateur() {
        User user = new User();
        user.setId(1);
        user.setNom("toto");
        user.setNumero(0600000000);
        user.setPasswd("toto_password");
        when(userDao.getById(user.getId())).thenReturn(user);

        User result = userService.getById(1);

        assertEquals(result, user);
    }
}
