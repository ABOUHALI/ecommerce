package model;

import java.io.InputStream;
import java.util.Base64;

public class Panier {
	private int idpanier;
	private int idclient;
	private int idproduit;
	private int prixT;
	private int qtte;
	
	
	//////////////////
	private String produit;
	private String photo;
	private InputStream is;
	private String description;
	
	public String getProduit() {
		return produit;
	}
	public void setProduit(String produit) {
		this.produit = produit;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public InputStream getIs() {
		return is;
	}
	public void setIs(InputStream is) {
		this.is = is;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIdpanier() {
		return idpanier;
	}
	public void setIdpanier(int idpanier) {
		this.idpanier = idpanier;
	}
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	public int getIdproduit() {
		return idproduit;
	}
	public void setIdproduit(int idproduit) {
		this.idproduit = idproduit;
	}
	public int getPrixT() {
		return prixT;
	}
	public void setPrixT(int prixT) {
		this.prixT = prixT;
	}
	public int getQtte() {
		return qtte;
	}
	public void setQtte(int qtte) {
		this.qtte = qtte;
	}
	
}
