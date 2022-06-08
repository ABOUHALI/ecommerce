package model;

public class Panier {
	private int idpanier;
	private int idclient;
	private int idproduit;
	private int prixT;
	private int qtte;
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
