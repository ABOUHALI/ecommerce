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

import model.Famille;
import model.Fournisseur;
import model.Produit;
import model.Users;


public class ProduitDAO {
	

	public void addProduit(Produit produit) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;

		try {
			ps = conn.prepareStatement("insert into produit(`nom`, `prix`, `idfamille`, `description`, `image` , `quantite`, `idfournisseur`)  values(?,?,?,?,?,?,?) ");
			ps.setString(1, produit.getNom());
			ps.setDouble(2, produit.getPrix());
			ps.setInt(3, produit.getIdfamille());
			ps.setString(4, produit.getDescription());
			ps.setBlob(5, produit.getImage());
			ps.setDouble(6, produit.getQtte());
			ps.setInt(7, produit.getIdfournisseur());
			ps.executeUpdate();
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
	}
	public int getIdFour(String f){
		Connection conn =SingletonConnection.getConnection();
		PreparedStatement ps;
		int id=0;
		try {
			ps=conn.prepareStatement("select idfournisseur from fournisseur where nom=? ");
			ps.setString(1,f);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				id=rs.getInt("idfournisseur");
				System.out.println("id four is"+id);
			}
		}catch (Exception e) {
			// TODO: handle exception
		
		}
		return id;
	}
	public int getIdFammile(String f){
		Connection conn =SingletonConnection.getConnection();
		PreparedStatement ps;
		int id=0;
		try {
			ps=conn.prepareStatement("select idfamille from famille where nom=? ");
			ps.setString(1,f);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				id=rs.getInt("idfamille");
				System.out.println("id fam is"+id);
			}
		}catch (Exception e) {
			// TODO: handle exception
		
		}
		return id;
	}
	public List<Produit> listerProduit() {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		List<Produit> produits =new ArrayList<Produit>();
		try {
			ps = conn.prepareStatement("select * from produit");
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {	
				System.out.println("entred");
			Produit produit = new Produit();
				produit.setId_produit(rs.getInt("idproduit"));
				produit.setNom(rs.getString("nom"));
				produit.setPrix(rs.getDouble("prix"));
				produit.setDescription(rs.getString("description"));
				produit.setQtte(rs.getInt("quantite"));
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
				System.out.println(produit.getNom());
				produits.add(produit);
			
				inputStream.close();
				outputStream.close();
			}
			} catch (Exception e) {
				// TODO: handle exception
			}
		return produits;
	}	
	
	public void deleteProduit(int idproduit) {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
		String sql = "delete from produit where idproduit=?";
		ps =conn.prepareStatement(sql);
		ps.setInt(1, idproduit);
		ps.executeUpdate();

		} catch (Exception e) {
			System.err.println("problem in deleting ...");
		}
		} 
	
	
	public void modifierProduit(Produit produit) {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			if(produit.getImage()!=null) {
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
			}else {
				ps =conn.prepareStatement("update  produit set nom=?,idfamille=?,description=?,quantite=?,idfournisseur=?"
						+ " where idproduit=?");
				ps.setString(1,produit.getNom());
				ps.setString(3, produit.getDescription());
				ps.setInt(2, produit.getIdfamille());
				ps.setInt(4, produit.getQtte());
				ps.setInt(5, produit.getIdfournisseur());
				ps.setInt(6, produit.getId_produit());
				ps.executeUpdate();
			}
			
		}catch(Exception e ) {	
			
		}
		}
	
	




}
