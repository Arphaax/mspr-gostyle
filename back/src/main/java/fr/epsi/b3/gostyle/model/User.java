package fr.epsi.b3.gostyle.model;

import javax.persistence.*;
import java.util.List;

@Entity(name="Utilisateur")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String prenom;
    private String numero;
    private String passwd;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Used_code",
            joinColumns = @JoinColumn(name = "Utilisateurid"),
            inverseJoinColumns = @JoinColumn(name = "QRCodeID"))
    private List<Qrcode> qrcodes;

    public User() {
    }

    public User(int id, String nom, String prenom, String numero, String passwd) {
        super();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.passwd = passwd;
    }

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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
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