package fr.epsi.b3.gostyle.security;

import java.io.Serializable;

public class JwtRequest implements Serializable {

    private String numero;

    private String password;

    public JwtRequest(){}

    public JwtRequest(String numero, String password) {
        this.setNumero(numero);
        this.setPassword(password);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
