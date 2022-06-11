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
import model.Produit;

public class FamilleDAO {
	

	public void addFamille(Famille famille) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("insert into famille(nom,image) values(?,?)");
			ps.setString(1,famille.getNom());
			ps.setBlob(2, famille.getImage());
			ps.executeUpdate();
			}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Famille> listerFamilles(){
		List<Famille> lfamilles = new ArrayList();
		Connection conn =SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("select * from famille");
			
			ResultSet rs = ps.executeQuery();
		    while(rs.next()) {
		    	Famille f = new Famille();
		    	//System.out.println(rs.getObject(0));
		    	f.setIdfamille(rs.getInt("idfamille"));
		    	f.setNom(rs.getString("nom"));
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
				f.setBase64Image(base64Image);
				lfamilles.add(f);
			
				inputStream.close();
				outputStream.close();
			}
		   
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lfamilles;
	}
	
	public static boolean deleteFamille(Famille famille) {
		boolean b = false;
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
		String sql = "delete from famille where idfamille=?";
		ps =conn.prepareStatement(sql);
		ps.setInt(1, famille.getIdfamille());
		ps.executeUpdate();
		b = true;

		} catch (Exception e) {
			System.err.println("problem in deleting ...");
		}
		return b;
		} 
	
	
	public void modifierFamille(Famille famille) {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		String sqlimage="update  famille set nom=?,image=? where idfamille=?";
		String sql ="update  famille set nom=? where idfamille=?";
		try {
			System.out.println(famille.getImage());
			if(famille.getImage()!=null) {
			ps =conn.prepareStatement(sqlimage);
			ps.setString(1,famille.getNom());
			ps.setBlob(2,famille.getImage());
			ps.setInt(3, famille.getIdfamille());
			ps.executeUpdate();
			}else {
				ps =conn.prepareStatement(sql);
				ps.setString(1,famille.getNom());
				ps.setInt(2, famille.getIdfamille());
				ps.executeUpdate();
			}
		}catch(Exception e ) {	
			e.printStackTrace();
		}
	}
	


}
