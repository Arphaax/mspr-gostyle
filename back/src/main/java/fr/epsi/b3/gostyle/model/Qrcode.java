package fr.epsi.b3.gostyle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "QRCode")
public class Qrcode {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	private String libelle;
	private int montant;
	
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
}
