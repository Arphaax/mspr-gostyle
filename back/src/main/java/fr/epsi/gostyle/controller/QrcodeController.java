package fr.epsi.gostyle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.epsi.gostyle.model.Qrcode;
import fr.epsi.gostyle.model.exception.Erreur;
import fr.epsi.gostyle.model.exception.QrcodeNotFoundException;
import fr.epsi.gostyle.services.QrcodeService;

@Controller
public class QrcodeController {
	
	@Autowired
	private QrcodeService qrcodeService;
	
	@ExceptionHandler(QrcodeNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Erreur handleInscriptionInexistanteException(QrcodeNotFoundException e) {
		return new Erreur(e);
	}
	
	@GetMapping(path="api/qrcodes/{location}", produces="application/json")
	public Qrcode getQrcode(@PathVariable int location)throws QrcodeNotFoundException {
		return qrcodeService.find(location);
	}
}
