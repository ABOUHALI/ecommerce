package model;

import java.io.FileInputStream;
import java.io.InputStream;

public class Produit {
	private int id_produit;
	private String nom;
	private double prix;
	private int idfamille;
	private int idfournisseur;
	private String description;
	private InputStream image;
	private int qtte;
	
	
	private String base64Image;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIdfamille() {
		return idfamille;
	}
	public void setIdfamille(int idfamille) {
		this.idfamille = idfamille;
	}
	public int getIdfournisseur() {
		return idfournisseur;
	}
	public void setIdfournisseur(int idfournisseur) {
		this.idfournisseur = idfournisseur;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	
	public int getId_produit() {
		return id_produit;
	}
	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public InputStream getImage() {
		return image;
	}
	public void setImage(FileInputStream image) {
		this.image = image;
	}
	public int getQtte() {
		return qtte;
	}
	public void setQtte(int qtte) {
		this.qtte = qtte;
	}
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	
}
