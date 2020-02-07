package fr.epsi.b3.gostyle.dao;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import fr.epsi.b3.gostyle.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.persistence.EntityManager;

public class UserDaoTest {
    private UserDao userDao;
    private EntityManager mockedEm;

    @Before
    public void init() {
        this.mockedEm = mock(EntityManager.class);
        this.userDao = new UserDao();
    }

    @Test
    public void getByIdTrouveEtRetourneUnUtilisateurViaSonId() {
        User user = new User();
        user.setId(1);
        user.setNom("toto");
        user.setNumero("0670707070");

        int id = 1;
        when(mockedEm.find(User.class, id)).thenReturn(user);

        User result = userDao.getById(id);

        assertEquals(result, user);
    }
}
