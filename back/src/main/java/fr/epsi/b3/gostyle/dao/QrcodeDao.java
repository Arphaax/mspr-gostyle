package fr.epsi.b3.gostyle.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.epsi.b3.gostyle.exception.QrcodeNotFoundException;
import org.springframework.stereotype.Repository;

import fr.epsi.b3.gostyle.model.Qrcode;

@Repository
public class QrcodeDao {
	@PersistenceContext
	private EntityManager em;

	public Qrcode findById(Integer id) {
		return em.find(Qrcode.class, id);
	}

	public Qrcode findBylibelle(String libelle) throws QrcodeNotFoundException {
		try{
			return em.createQuery("SELECT q from QRCode q where q.libelle=:libelle", Qrcode.class).setParameter("libelle",libelle).getSingleResult();
		}
		catch (NoResultException e){
			throw new QrcodeNotFoundException(e.getMessage());
		}

	}

}
