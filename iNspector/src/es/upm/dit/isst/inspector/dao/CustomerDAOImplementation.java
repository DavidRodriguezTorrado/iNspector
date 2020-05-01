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

public class CustomerDAOImplementation implements CustomerDAO {

	private static  CustomerDAOImplementation instancia = null;
	
	private CustomerDAOImplementation() {
	}

	public static CustomerDAOImplementation getInstance() {
		if( null == instancia ) 
			instancia = new CustomerDAOImplementation();
		return instancia;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void create(Customer customer) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		String email = customer.getEmail();
		String name = customer.getName();
		String password = customer.getPassword();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			PreparedStatement ps =con.prepareStatement("INSERT INTO CUSTOMERS " +
					"(email, name, password) " +
					"VALUES ('" + email + "', '" + name + "', '" + password + "')");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();


	}
	@SuppressWarnings("unchecked")
	@Override
	public Customer read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Customer cust = new Customer();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT * FROM CUSTOMERS WHERE email= '" +email+"'");
			if(res.next()) {
				
				cust.setEmail(res.getString(1));
				cust.setName(res.getString(2));
				cust.setPassword(res.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return cust;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void update(Customer customer) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		String email = customer.getEmail();
		String name = customer.getName();
		String password = customer.getPassword();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			PreparedStatement ps = con.prepareStatement("UPDATE customers SET email='"+email+"', name='"+name+"', password='"+password+"'" 
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
	public void delete(Customer customer) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(customer);
		session.getTransaction().commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Customer> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List <Customer> cust = (List<Customer>)session.createQuery("from Customer").list();
		session.getTransaction().commit();
		session.close();
		return cust;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Customer login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Customer cust= new Customer();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT * FROM CUSTOMERS WHERE email= '" +email+"' and password= '" + password+ "'");
			if(res.next()) {
			cust.setEmail(res.getString(1));
			cust.setName(res.getString(2));
			cust.setPassword(res.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return cust;

	}

}
