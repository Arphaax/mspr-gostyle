package fr.epsi.b3.gostyle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    @Autowired
    private UserService userService;

    public String authenticate(String numero, String passwd) {
        if (userService.verifyLogins(numero, passwd)) {
            String token = "";
            return token;
        }
        else {
            return null;
        }
    }
}
