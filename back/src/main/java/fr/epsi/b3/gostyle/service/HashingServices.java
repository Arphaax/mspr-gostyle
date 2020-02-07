package fr.epsi.b3.gostyle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
public class HashingServices {
    private Argon2PasswordEncoder argon2;

    public HashingServices() {
        argon2 = new Argon2PasswordEncoder();
    }

    /*
     * Hash un mot de passe utilisant l'algorythme Argon2
     * Le salt est généré automatiquement
     */
    public String hash(String motDePasse) {
        return argon2.encode(motDePasse);
    }

    /*
     * Verifie si le mot de passe donné correspond au hash donné
     *
     * Return :
     * true : si le mot de passe est correct
     * false : si le mot de passe est erroné
     */
    public boolean verifier(String motDePasse, String hash) {
        return argon2.matches(motDePasse, hash);
    }
}
