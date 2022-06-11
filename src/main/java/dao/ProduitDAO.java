package dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import model.Produit;


public class ProduitDAO {
	

	public void addProduit(Produit produit) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;

		try {
			ps = conn.prepareStatement("insert into produit values(?,?,?,?,?,?,?) ");
			ps.setString(1, produit.getNom());
			ps.setInt(2, produit.getIdfamille());
			ps.setString(3, produit.getDescription());
			ps.setBlob(4, produit.getImage());
			ps.setDouble(5, produit.getQtte());
			ps.setInt(6, produit.getIdfournisseur());
			ps.executeUpdate();
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	public List<Produit> listerProduit() {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		List<Produit> produits =new ArrayList<Produit>();
		try {
			ps = conn.prepareStatement("select * from produit");
			ResultSet rs =ps.executeQuery();
			while(true) {	
			Produit produit = new Produit();
				produit.setId_produit(rs.getInt("idproduit"));
				produit.setNom(rs.getString("nom"));
				produit.setPrix(rs.getDouble("prix"));
				produit.setDescription(rs.getString("description"));
				produit.setQtte(rs.getInt("qtte"));
				Blob blob = rs.getBlob("image");
				 
				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				 
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				    outputStream.write(buffer, 0, bytesRead);
				}
				 
				byte[] imageBytes = outputStream.toByteArray();
				 
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				produit.setBase64Image(base64Image);
				produits.add(produit);
			
				inputStream.close();
				outputStream.close();
			}
			} catch (Exception e) {
				// TODO: handle exception
			}
		return produits;
	}	
	
	public static boolean deleteProduit(Produit produit) {
		boolean b = false;
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
		String sql = "delete from produit where idproduit=?";
		ps =conn.prepareStatement(sql);
		ps.setInt(1, produit.getId_produit());
		ps.executeUpdate();
		b = true;

		} catch (Exception e) {
			System.err.println("problem in deleting ...");
		}
		return b;
		} 
	
	
	public void modifierProduit(Produit produit) {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps =conn.prepareStatement("update  produit set nom=?,idfamille=?,description=?,image=?,quantite=?,idfournisseur=?"
										+ " where idproduit=?");
			ps.setString(1,produit.getNom());
			ps.setString(3, produit.getDescription());
			ps.setInt(2, produit.getIdfamille());
			ps.setBlob(4, produit.getImage());
			ps.setInt(5, produit.getQtte());
			ps.setInt(6, produit.getIdfournisseur());
			ps.setInt(7, produit.getId_produit());
			ps.executeUpdate();
		}catch(Exception e ) {	
			
		}
		}
	
	




}
