package fr.epsi.b3.gostyle.model;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.List;

@Entity(name = "qrcode")
public class Qrcode extends RepresentationModel<Qrcode> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	private String libelle;
	private int montant;
	
	public Qrcode(int i, String string, int j) {
		super();
		ID = i;
		libelle = string;
		montant = j;
	}
	
	public Qrcode() {
	}
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
