package fr.epsi.gostyle.daos;

import fr.epsi.gostyle.modeles.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDao {
    @PersistenceContext
    EntityManager em;

    /**
     * Récupère un utilisateur avec son identifiant
     *
     * @param id
     */
    public User getById(int id) {
        return em.find(User.class, id);
    }
}
