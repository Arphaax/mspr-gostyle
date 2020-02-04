package fr.epsi.gostyle.daos;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import fr.epsi.gostyle.modeles.User;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserDaoTest {
    UserDao userDao;

    @PersistenceContext
    EntityManager em;

    @Before
    public void init() {
        this.userDao = new UserDao();
    }

    @Test
    public void getByIdTrouveEtRetourneUnUtilisateurViaSonId() {
        User user = new User();
        user.setId(1);
        user.setNom("toto");
        user.setNumero(0670707070);

        int id = 1;
        when(em.find(User.class, id)).thenReturn(user);

        User result = userDao.getById(id);

        assertEquals(result, user);
    }
}
