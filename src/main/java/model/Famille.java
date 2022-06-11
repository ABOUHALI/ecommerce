package model;

import java.io.FileInputStream;
import java.io.InputStream;

public class Famille {
	private int idfamille;
	private String nom;
	private InputStream  image;
	
	
	private String base64Image;
	
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
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
