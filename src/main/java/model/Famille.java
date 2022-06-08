package model;

import java.io.FileInputStream;
import java.io.InputStream;

public class Famille {
	private int idfamille;
	private String nom;
	private InputStream  image;
	public int getIdfamille() {
		return idfamille;
	}
	public void setIdfamille(int idfamille) {
		this.idfamille = idfamille;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	
}
