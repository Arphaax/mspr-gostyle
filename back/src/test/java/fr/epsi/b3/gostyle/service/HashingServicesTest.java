package fr.epsi.b3.gostyle.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashingServicesTest {
    HashingServices hashingServices;

    @Before
    public void init() {
        this.hashingServices = new HashingServices();
    }

    @Test
    public void hashRetourneUnMotDePasseHasheEnArgon2() {
        String motDePasse = "test";
        String resultatAttendu = "$argon2id$v=19$m=4096,t=3,p=1$";

        String hash = hashingServices.hash(motDePasse);

        assertEquals(resultatAttendu, hash.substring(0, 30));
    }

    @Test
    public void verifierRetourneTrueSiLeMotDePasseEstCorrect() {
        String motDePasse = "test";

        String hash = hashingServices.hash(motDePasse);

        assertTrue(hashingServices.verifier(motDePasse, hash));
    }

    @Test
    public void verifierRetourneFalseSiLeMotDePasseEstErrone() {
        String motDePasse = "test";
        String motDePasseErrone = "toto";

        String hash = hashingServices.hash(motDePasse);

        assertFalse(hashingServices.verifier(motDePasseErrone, hash));
    }
}
