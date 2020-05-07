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
import es.upm.dit.isst.inspector.model.Ultimo;

public class UltimoDAOImplementation implements UltimoDAO {

	private static  UltimoDAOImplementation instancia = null;
	
	private UltimoDAOImplementation() {
	}

	public static UltimoDAOImplementation getInstance() {
		if( null == instancia ) 
			instancia = new UltimoDAOImplementation();
		return instancia;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void create(Ultimo ultimo) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Customer customer = ultimo.getCustomer();
		String customer1 = customer.getEmail();
		Local local = ultimo.getLocal();
		int idLocal= LocalDAOImplementation.getInstance().read1(local.getRotulo());
		String fecha = ultimo.getFecha();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			PreparedStatement ps =con.prepareStatement("INSERT INTO ULTIMOS " +
					"(customer, local, fecha) " +
					"VALUES ('" + customer1 + "', '" + idLocal + "', '" + fecha + "')");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();


	}
	@SuppressWarnings("unchecked")
	@Override
	public Ultimo read(String email, String rotulo) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Ultimo ult = new Ultimo();
		Customer cust = new Customer();
		Local loc = new Local();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT * FROM ULTIMOS WHERE customer= '" +email+"' and local='" +rotulo+ "' ORDER BY id DESC");
			if(res.next()) {
				
				ult.setId(res.getInt(1));
				cust.setEmail(res.getString(2));
				ult.setCustomer(cust);
				loc.setRotulo(res.getString(3));
				ult.setLocal(loc);
				ult.setFecha(res.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return ult;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete(int id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("DELETE * FROM Ultimos WHERE id= '" +id+"'");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	@Override
	public Ultimo read1(int id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Ultimo ultimo = new Ultimo();
		Customer cust = new Customer();
		Local loc = new Local();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT * FROM ULTIMOS WHERE id= '" +id+"'");
			if(res.next()) {
				
				ultimo.setId(res.getInt(1));
				cust.setEmail(res.getString(2));
				ultimo.setCustomer(cust);
				loc.setId(res.getInt(3));
				ultimo.setLocal(loc);
				ultimo.setFecha(res.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return ultimo;
	}
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Integer> misUltimos(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		ArrayList<Integer> misFavoritos = new ArrayList<Integer>();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT DISTINCT ID FROM ULTIMOS WHERE customer like '%" +email+"%'");
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
