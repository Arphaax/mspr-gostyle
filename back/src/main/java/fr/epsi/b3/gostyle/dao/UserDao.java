package fr.epsi.b3.gostyle.dao;

import fr.epsi.b3.gostyle.model.Qrcode;
import fr.epsi.b3.gostyle.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager em;

    /**
     * Récupère un utilisateur avec son identifiant
     *
     * @param id
     */
    @Transactional(readOnly = true)
    public User getById(int id) {
        return em.find(User.class, id);
    }

    @Transactional(readOnly = true)
    public User getByLogin(int numero) {
        return em.find(User.class, numero);
    }

    @Transactional(readOnly = true)
    public List<Qrcode> getAllQrCodesOfUser(int id) {
        ArrayList<Qrcode> qrcodes = new ArrayList<>();
        return getById(id).getQrcodes();
    }
}
