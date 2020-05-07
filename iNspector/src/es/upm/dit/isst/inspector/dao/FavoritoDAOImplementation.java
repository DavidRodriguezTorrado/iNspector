package es.upm.dit.isst.inspector.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.hibernate.Session;

import es.upm.dit.isst.inspector.model.Customer;
import es.upm.dit.isst.inspector.model.Favorito;
import es.upm.dit.isst.inspector.model.Local;


public class FavoritoDAOImplementation implements FavoritoDAO {

	private static  FavoritoDAOImplementation instancia = null;
	
	private FavoritoDAOImplementation() {
	}

	public static FavoritoDAOImplementation getInstance() {
		if( null == instancia ) 
			instancia = new FavoritoDAOImplementation();
		return instancia;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void create(Favorito favorito) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Customer customer = favorito.getCustomer();
		String customer1 = customer.getEmail();
		Local local = favorito.getLocal();
		int local1 = local.getId();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			PreparedStatement ps =con.prepareStatement("INSERT INTO FAVORITOS " +
					"(customer, local) " +
					"VALUES ('" + customer1 + "', '" + local1 + "')");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();


	}
	@SuppressWarnings("unchecked")
	@Override
	public Favorito read(String email, String rotulo) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Favorito fav = new Favorito();
		Customer cust = new Customer();
		Local loc = new Local();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT * FROM FAVORITOS WHERE customer= '" +email+"' and local='" +rotulo+ "'");
			if(res.next()) {
				
				fav.setId(res.getInt(1));
				cust.setEmail(res.getString(2));
				fav.setCustomer(cust);
				loc.setRotulo(res.getString(3));
				fav.setLocal(loc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return fav;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Favorito read1(int id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Favorito fav = new Favorito();
		Customer cust = new Customer();
		Local loc = new Local();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT * FROM FAVORITOS WHERE id= '" +id+"'");
			if(res.next()) {
				
				fav.setId(res.getInt(1));
				cust.setEmail(res.getString(2));
				fav.setCustomer(cust);
				loc.setId(res.getInt(3));
				fav.setLocal(loc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return fav;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete(String email, String rotulo) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		int idLocal= LocalDAOImplementation.getInstance().read1(rotulo);
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			PreparedStatement ps = con.prepareStatement("DELETE FROM Favoritos WHERE customer= '" +email+"' and local='" +idLocal+ "'");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
	}

	public ArrayList<Integer> misFavoritos(String email){
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		ArrayList<Integer> misFavoritos = new ArrayList<Integer>();
		try {
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT DISTINCT ID, customer, local FROM FAVORITOS WHERE customer like '%" +email+"%'");
			while(res.next()) {
				misFavoritos.add((res.getInt(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return misFavoritos;
	}

}
