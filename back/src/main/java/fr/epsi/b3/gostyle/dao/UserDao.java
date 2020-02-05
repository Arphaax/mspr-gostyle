package fr.epsi.b3.gostyle.dao;

import fr.epsi.b3.gostyle.modele.User;
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
