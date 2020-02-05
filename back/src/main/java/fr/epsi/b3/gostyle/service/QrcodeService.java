package fr.epsi.b3.gostyle.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.epsi.gostyle.dao.QrcodeDao;
import fr.epsi.gostyle.model.Qrcode;
import fr.epsi.gostyle.model.exception.QrcodeNotFoundException;

@Service
public class QrcodeService {
	@Autowired
	private QrcodeDao qrcodeDao;

	@Transactional
	public Qrcode find(Integer id) throws QrcodeNotFoundException {
		Qrcode qrcode = qrcodeDao.findById(id);
		if(qrcode == null) {
			throw new QrcodeNotFoundException("Qrcode not found");
		}
		return qrcode;
	}

}
