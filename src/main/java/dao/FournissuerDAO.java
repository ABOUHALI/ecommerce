package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Famille;
import model.Fournisseur;
import model.Panier;

public class FournissuerDAO {
	public void addFournisseur(Fournisseur f) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("insert into fournisseur(nom,email,tel,prenom) values(?,?,?,?)");
			ps.setString(1, f.getNom());
			ps.setString(2, f.getEmail());
			ps.setString(3, f.getTel());
			ps.setString(4, f.getPrenom());
			ps.executeUpdate();
		} catch (Exception e) {
				e.printStackTrace();
		}
	}

	public List<Fournisseur> ListFournisseur() {
		List<Fournisseur> lf = new ArrayList<Fournisseur>();
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from fournisseur");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Fournisseur f =new Fournisseur();
				f.setIdfournisseur(rs.getInt("idfournisseur"));
				f.setPrenom(rs.getString("prenom"));
				f.setNom(rs.getString("nom"));
				f.setTel(rs.getString("tel"));
				f.setEmail(rs.getString("email"));
			
				lf.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lf;
	}
	
	public void modifierFournisseu(Fournisseur f ) {
			Connection conn = SingletonConnection.getConnection();
			PreparedStatement ps;
			try {
				ps =conn.prepareStatement("update  fournisseur set nom=?,email=?,tel=?,prenom=?"
											+ " where idfournisseur=?");
				ps.setString(1, f.getNom());
				ps.setString(2, f.getEmail());
				ps.setString(3, f.getTel());
				ps.setString(4, f.getPrenom());
				ps.setInt(5, f.getIdfournisseur());
				ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}

}
}