package fr.epsi.b3.gostyle.model;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "utilisateur")
public class User extends RepresentationModel<User> {

    @Id
    private int id;
    private String nom;
    private String prenom;
    private int numero;
    private String passwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String psswd) {
        this.passwd = psswd;
    }
}
