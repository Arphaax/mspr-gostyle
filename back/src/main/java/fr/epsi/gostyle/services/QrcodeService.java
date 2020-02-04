package fr.epsi.gostyle.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epsi.gostyle.dao.QrcodeDao;
import fr.epsi.gostyle.model.Qrcode;

@Service
public class QrcodeService {
	
	@Autowired
	private QrcodeDao qrcodeDao;
	
	@Transactional
	public Qrcode find(Integer id) {
		return qrcodeDao.findById(id);
	}

}
