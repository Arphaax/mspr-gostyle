package fr.epsi.b3.gostyle.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import fr.epsi.b3.gostyle.model.Qrcode;

@Repository
public class QrcodeDao {
	@PersistenceContext
	private EntityManager em;

	public Qrcode findById(Integer id) {
		return em.find(Qrcode.class, id);
	}

}
