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
import es.upm.dit.isst.inspector.model.Local;

public class LocalDAOImplementation implements LocalDAO {

	private static  LocalDAOImplementation instancia = null;
	
	private LocalDAOImplementation() {
	}

	public static LocalDAOImplementation getInstance() {
		if( null == instancia ) 
			instancia = new LocalDAOImplementation();
		return instancia;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void create(Local local) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		String rotulo = local.getRotulo();
		String direccion = local.getDireccion();
		String epigrafe = local.getEpigrafe();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			PreparedStatement ps =con.prepareStatement("INSERT INTO LOCALES " +
					"(rotulo, direccion, epigrafe) " +
					"VALUES ('" + rotulo + "', '" + direccion + "', '" + epigrafe + "')");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();


	}
	@SuppressWarnings("unchecked")
	@Override
	public int read1(String name) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Local local = new Local();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT * FROM LOCALES WHERE rotulo= '" +name+"'");
			if(res.next()) {
				
				local.setId(res.getInt(1));
				local.setRotulo(res.getString(2));
				local.setDireccion(res.getString(3));
				local.setEpigrafe(res.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return local.getId();
	}
	@SuppressWarnings("unchecked")
	@Override
	public Local read(String name) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Local local = new Local();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT * FROM LOCALES WHERE rotulo= '" +name+"'");
			if(res.next()) {
				
				local.setId(res.getInt(1));
				local.setRotulo(res.getString(2));
				local.setDireccion(res.getString(3));
				local.setEpigrafe(res.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return local;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Local read2(int id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Local local = new Local();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT * FROM LOCALES WHERE id= '" +id+"'");
			if(res.next()) {
				
				local.setId(res.getInt(1));
				local.setRotulo(res.getString(2));
				local.setDireccion(res.getString(3));
				local.setEpigrafe(res.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return local;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void update(Local local) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(local);
		session.getTransaction().commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	@Override
	public void delete(String name) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("DELETE * FROM LOCALES WHERE rotulo= '" +name+"'");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Local> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List <Local> locales = session.createQuery("from Local").list();
		session.getTransaction().commit();
		session.close();
		return locales;
	}
}
