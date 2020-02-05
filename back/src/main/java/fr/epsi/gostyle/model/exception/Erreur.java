package fr.epsi.gostyle.model.exception;

public class Erreur {
private String message;
	
	public Erreur(Exception e) {
		this.message = e.getMessage();
	}
	public String getMessage() {
		return message;
	}
}
