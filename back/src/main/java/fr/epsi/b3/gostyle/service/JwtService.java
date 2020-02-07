package fr.epsi.b3.gostyle.service;

import fr.epsi.b3.gostyle.exception.IncorrectLoginsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    @Autowired
    private UserService userService;

    public String authenticate(String numero, String passwd) throws IncorrectLoginsException {
        if (userService.verifyLogins(numero, passwd)) {
            String token = "YIHAAA";
            return token;
        }
        else {
            throw new IncorrectLoginsException("Le login ou le mot de passe est incorrect");
        }
    }
}
