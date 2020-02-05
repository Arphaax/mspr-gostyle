package fr.epsi.b3.gostyle.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "QRCode")
public class Qrcode {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	private String libelle;
	private int montant;

/*	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "used_code",
			joinColumns = @JoinColumn(name = "QRCodeID"),
			inverseJoinColumns = @JoinColumn(name = "Utilisateurid"))
	private List<User> users;*/
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public int getID() {
		return ID;
	}

/*	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}*/
}
