package fr.epsi.gostyle.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
