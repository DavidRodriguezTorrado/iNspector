package es.upm.dit.isst.inspector.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.inspector.model.Customer;
import es.upm.dit.isst.inspector.model.Inspector;

public class InspectorDAOImplementation implements InspectorDAO {

	private static  InspectorDAOImplementation instancia = null;
	
	private InspectorDAOImplementation() {
	}

	public static InspectorDAOImplementation getInstance() {
		if( null == instancia ) 
			instancia = new InspectorDAOImplementation();
		return instancia;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void create(Inspector inspector) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		String email = inspector.getEmail();
		String name = inspector.getName();
		String password = inspector.getPassword();
		String autorizado = "no";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			PreparedStatement ps =con.prepareStatement("INSERT INTO INSPECTORES" +
					"(email, name, password, autorizado) " +
					"VALUES ('" + email + "', '" + name + "', '" + password + "', '" + autorizado + "')");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();

	}
	@SuppressWarnings("unchecked")
	@Override
	public Inspector read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Inspector insp = new Inspector();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT * FROM INSPECTORES WHERE email= '" +email+"'");
			if(res.next()) {
				
				insp.setEmail(res.getString(1));
				insp.setName(res.getString(2));
				insp.setPassword(res.getString(3));
				insp.setAutorizado(res.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return insp;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void update(Inspector inspector) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		String email = inspector.getEmail();
		String name = inspector.getName();
		String password = inspector.getPassword();
		String autorizado = inspector.getAutorizado();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			PreparedStatement ps = con.prepareStatement("UPDATE inspectores SET email='"+email+"', name='"+name+"', password='"+password+"'" 
					+ "WHERE email='"+email+"'");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	@Override
	public void delete(Inspector inspector) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(inspector);
		session.getTransaction().commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Inspector> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List <Inspector> inspectores = session.createQuery("from Inspector").list();
		session.getTransaction().commit();
		session.close();
		return inspectores;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Inspector login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Inspector insp= new Inspector();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT * FROM INSPECTORES WHERE email= '" +email+"' and password= '" + password+ "'");
			if(res.next()) {
			insp.setEmail(res.getString(1));
			insp.setName(res.getString(2));
			insp.setPassword(res.getString(3));
			insp.setAutorizado(res.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return insp;
	}

}
