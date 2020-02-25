package fr.epsi.b3.gostyle.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import fr.epsi.b3.gostyle.model.Qrcode;
import fr.epsi.b3.gostyle.dto.QrcodeDto;
import fr.epsi.b3.gostyle.exception.Erreur;
import fr.epsi.b3.gostyle.exception.QrcodeNotFoundException;
import fr.epsi.b3.gostyle.service.QrcodeService;

import java.net.http.HttpResponse;

@RestController
@RequestMapping(value = "/api/qrcodes", produces = "application/hal+json", consumes = "application/json")
public class QrcodeController {
	
	@Autowired
	private QrcodeService qrcodeService;
	
	@ExceptionHandler(QrcodeNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Erreur handleInscriptionInexistanteException(QrcodeNotFoundException e) {
		return new Erreur(e);
	}
	
	@GetMapping(path="/id/{location}", produces="application/json")
	public Qrcode getQrcodeById(@PathVariable int location)throws QrcodeNotFoundException {
		return qrcodeService.findById(location);
	}

	@GetMapping(path="/label/{location}", produces="application/json")
	public Qrcode getQrcodeByLibelle(@PathVariable String location)throws QrcodeNotFoundException {
		return qrcodeService.findByLibelle(location);
	}
	
	@PostMapping(path="/find" ,produces="application/json",consumes = "application/json")
	public Qrcode getQrcode(@RequestBody QrcodeDto qrcodedto)throws QrcodeNotFoundException {

		try {
			if(qrcodedto.getLibelle().isEmpty() || qrcodedto.getLibelle() == null) {
				return qrcodeService.findById(Integer.parseInt(qrcodedto.getId()));
			}else if(qrcodedto.getId().isEmpty() || qrcodedto.getId() == null) {
				return qrcodeService.findByLibelle(qrcodedto.getLibelle());
			}else if(!qrcodedto.getId().isEmpty() && !qrcodedto.getLibelle().isEmpty()) {
				return qrcodeService.findById(Integer.parseInt(qrcodedto.getId()));
			}
		}catch(Exception e) {
			throw new QrcodeNotFoundException("Aucun qrcode ne correspond");
		}
		throw new QrcodeNotFoundException("Aucun qrcode ne correspond");
	}
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Integer> remove(@PathVariable int id) throws QrcodeNotFoundException {
		qrcodeService.remove(id);

		return new ResponseEntity<>(id, HttpStatus.OK);

	}
}
