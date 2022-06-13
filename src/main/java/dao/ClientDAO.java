package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Client;
import model.Users;

public class ClientDAO {
	
	
	public void addClient(Client c,int id_u) {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			System.out.println("in dao");
			ps=conn.prepareStatement("insert into client (`nom`, `prenom`, `email`, `telephone`, `idusers`) values(?,?,?,?,?)");
			ps.setString(1,c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getTelephone());
			ps.setInt(5, id_u);
			ps.executeUpdate();
	}catch(Exception e) {
			
		}
	}
		
		public List<Client> listerClient(){
			List<Client> clients = new ArrayList();
			Connection conn =SingletonConnection.getConnection();
			PreparedStatement ps;
			try {
				ps=conn.prepareStatement("select * from client");

				ResultSet rs = ps.executeQuery();
				while(true) {
					Client c =new Client();
					c.setId_client(rs.getInt("idclient"));
					c.setNom(rs.getString("nom"));
					c.setPrenom(rs.getString("prenom"));
					c.setEmail(rs.getString("email"));
					c.setTelephone(rs.getString("telephone"));
					c.setId_user(rs.getInt("idusers"));
					
					clients.add(c);
				}
			}catch (Exception e) {
				// TODO: handle exception
			
			}
			return clients;
		}
		public int getIdUser(Users u){
			Connection conn =SingletonConnection.getConnection();
			PreparedStatement ps;
			int id=0;
			try {
				ps=conn.prepareStatement("select idusers from users where username=? and password=?");
				ps.setString(1,u.getLogin());
				System.out.println(";"+u.getLogin()+";");
				ps.setString(2, u.getMdp());
				System.out.println(";"+u.getMdp()+";");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					id=rs.getInt("idusers");
					System.out.println("id user is"+id);
				}
			}catch (Exception e) {
				// TODO: handle exception
			
			}
			return id;
		}
		
		
		public int getIdClient(int idusers){
			Connection conn =SingletonConnection.getConnection();
			PreparedStatement ps;
			int id=0;
			try {
				ps=conn.prepareStatement("select idclient from client where idusers=?");
				ps.setInt(1,idusers);
				//System.out.println(";"+u.getLogin()+";");
				//ps.setString(2, u.getMdp());
				//System.out.println(";"+u.getMdp()+";");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					id=rs.getInt("idclient");
					System.out.println("id user is"+id);
				}
			}catch (Exception e) {
				// TODO: handle exception
			
			}
			return id;
		}
		
		public void addUser(Users user) {
			Connection conn = SingletonConnection.getConnection();
			PreparedStatement ps;
			try {
				ps=conn.prepareStatement("insert into users (`username`, `password`, `role`) values(?,?,?)");
				ps.setString(1, user.getLogin());
				ps.setString(2, user.getMdp());
				ps.setString(3, "client");
				ps.executeUpdate();
			}catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
			}
}
}