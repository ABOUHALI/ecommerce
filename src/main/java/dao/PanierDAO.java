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
			ps.setInt(4, 1);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	public void reserver(int id_client) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {

			ps=conn.prepareStatement("update  panier set reserve=1 where idclient=?");
			ps.setInt(1, id_client);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public List<Panier> ListPanier() {
		List<Panier> lpaniers =new ArrayList<Panier>();
		Connection conn =SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("select p.*,pr.nom,pr.prix,pr.image ,pr.description from panier p,produit pr where p.idproduit=pr.idproduit");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Panier panier =new Panier();
				byte r = rs.getByte("reserve");
				panier.setReserve(false);
				if(r==1) {
					panier.setReserve(true);
				}
				panier.setIdclient(rs.getInt("idclient"));
				panier.setIdpanier(rs.getInt("idpanier"));
				panier.setIdproduit(rs.getInt("idproduit"));
				panier.setPrixT(rs.getInt("prixT"));
				panier.setQtte(rs.getInt("quantite"));
				panier.setProduit(rs.getString("nom"));
				panier.setDescription(rs.getString("description"));
				
				
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
		e.printStackTrace();
	}
		return lpaniers;
}
	
	
	public void deletePanier(int idpanier) {
		boolean b = false;
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
		String sql = "delete from panier where idpanier=?";
		ps =conn.prepareStatement(sql);
		ps.setInt(1,idpanier);
		ps.executeUpdate();
		b = true;

		} catch (Exception e) {
			System.err.println("problem in deleting ...");
		}
		//return b;
		} 
	
	public void modifierPanier(int idp,int qtte) {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		String sql="update  panier set quantite=? where idpanier=?";
		try {
			ps =conn.prepareStatement(sql);
			ps.setInt(1, qtte);
			ps.setInt(2, idp);
			ps.executeUpdate();
			ps.close();
		}catch(Exception e ) {
			e.printStackTrace();
		}
}
}
