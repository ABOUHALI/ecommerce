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
import model.Panier;

public class PanierDAO {

	public void addPanier(Panier panier) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {

			ps=conn.prepareStatement("insert into panier (`idclient`, `idproduit`, `prixT`, `quantite`) values(?,?,?,?)");
			ps.setInt(1, panier.getIdclient());
			ps.setInt(2, panier.getIdproduit());
			ps.setDouble(3, panier.getPrixT());
			ps.setInt(4, panier.getQtte());
			ps.executeUpdate();
		}catch(Exception e) {
			
		}
	
	}
	
	public List<Panier> ListPanier() {
		List<Panier> lpaniers =new ArrayList<Panier>();
		Connection conn =SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("select * from panier");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Panier panier =new Panier();
				panier.setIdclient(rs.getInt("idclient"));
				panier.setIdpanier(rs.getInt("idpanier"));
				panier.setIdproduit(rs.getInt("idproduit"));
				panier.setPrixT(rs.getInt("prixT"));
				panier.setQtte(rs.getInt("quantite"));
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
				panier.setPhoto(base64Image);
				lpaniers.add(panier);
			}
	
	}catch(Exception e ) {
		
	}
		return lpaniers;
}
}
