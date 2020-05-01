package es.upm.dit.isst.inspector.dao;

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
		session.save(customer);
		session.getTransaction().commit();
		session.close();


	}
	@SuppressWarnings("unchecked")
	@Override
	public Customer read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Customer p = session.get(Customer.class, email);
		session.getTransaction().commit();
		session.close();
		return p;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void update(Customer customer) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(customer);
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
		/*
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Customer p =null;
		Query q = session.createQuery("select * from Customer p where p.email = :email and p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Customer> cust = q.getResultList();
		if (cust.size() > 0)
			p = (Customer) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return p; */
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Customer p =null;
		Query q = session.createQuery("select * from Customer p where p.email = :email and p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Customer> cust = q.getResultList();
		if (cust.size() > 0)
			p = (Customer) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return p;
		
	}

}
