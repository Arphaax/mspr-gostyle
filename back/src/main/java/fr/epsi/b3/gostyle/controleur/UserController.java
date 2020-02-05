package fr.epsi.b3.gostyle.controleur;

import fr.epsi.b3.gostyle.model.Qrcode;
import fr.epsi.b3.gostyle.model.User;
import fr.epsi.b3.gostyle.service.UserService;
import fr.epsi.b3.gostyle.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private JwtService jwtService;


    /*
     *
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getById(@PathVariable String id) {
        User user = userService.getById(Integer.parseInt(id));

        if (user != null) {
            return ResponseEntity.ok(user);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/{numero}/authenticate")
    public ResponseEntity<String> authenticate(@PathVariable String numero,
                                               @RequestBody String passwd) {
        String jwt = jwtService.authenticate(Integer.parseInt(numero), passwd);

        if (jwt != null) {
            return ResponseEntity.ok(jwt);
        }
        else {
            return ResponseEntity.notFound().build();
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
