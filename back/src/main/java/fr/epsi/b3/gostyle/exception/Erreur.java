package fr.epsi.b3.gostyle.exception;

public class Erreur {
private String message;
	
	public Erreur(Exception e) {
		this.message = e.getMessage();
	}
	public String getMessage() {
		return message;
	}
}
