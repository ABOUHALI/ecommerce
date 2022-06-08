package model;

public class Fournisseur {
	private int idfournisseur;
	private String nom;
	private String email;
	private String prenom;
	private String tel;
	public int getIdfournisseur() {
		return idfournisseur;
	}
	public void setIdfournisseur(int idfournisseur) {
		this.idfournisseur = idfournisseur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
