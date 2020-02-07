package fr.epsi.b3.gostyle.controleur;

import fr.epsi.b3.gostyle.dto.UserDto;
import fr.epsi.b3.gostyle.exception.Erreur;
import fr.epsi.b3.gostyle.exception.QrcodeNotFoundException;
import fr.epsi.b3.gostyle.exception.UserNotFoundException;
import fr.epsi.b3.gostyle.model.Qrcode;
import fr.epsi.b3.gostyle.model.User;
import fr.epsi.b3.gostyle.service.HashingServices;
import fr.epsi.b3.gostyle.service.UserService;
import fr.epsi.b3.gostyle.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", produces = "application/hal+json", consumes = "application/json")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private HashingServices hashingServices;

    @Autowired
    private JwtService jwtService;

    @ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Erreur handleInscriptionInexistanteException(UserNotFoundException e) {
		return new Erreur(e);
	}
    /*
     *
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getById(@PathVariable String id) throws UserNotFoundException {
        User user = userService.getById(Integer.parseInt(id));

        if (user != null) {
            return ResponseEntity.ok(user);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody UserDto identif) {
        String jwt = jwtService.authenticate(identif.getNumero(), identif.getPassword());

        if (jwt != null) {
            return ResponseEntity.ok(jwt);
        }
        else {
            return ResponseEntity.status(200).build();
        }
    }

    @GetMapping(path = "/{id}/qrcodes")
    public ResponseEntity<List<Qrcode>> getAllQrCodesOfUser(@PathVariable String id) {
        List<Qrcode> qrcodes = userService.getAllQrCodesOfUser(Integer.parseInt(id));

        if (qrcodes.size() >= 1) {
            return ResponseEntity.ok(qrcodes);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
