package fr.epsi.b3.gostyle.model;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Utilisateur")
public class User extends RepresentationModel<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String prenom;
    private int numero;
    private String passwd;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Used_code",
            joinColumns = @JoinColumn(name = "Utilisateurid"),
            inverseJoinColumns = @JoinColumn(name = "QRCodeID"))
    private List<Qrcode> qrcodes;

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

    public List<Qrcode> getQrcodes() {
        return qrcodes;
    }

    public void setQrcodes(List<Qrcode> qrcodes) {
        this.qrcodes = qrcodes;
    }
}
