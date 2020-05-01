package es.upm.dit.isst.inspector.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.inspector.model.Admin;

public class AdminDAOImplementation implements AdminDAO {

	private static  AdminDAOImplementation instancia = null;
	
	private AdminDAOImplementation() {
	}

	public static AdminDAOImplementation getInstance() {
		if( null == instancia ) 
			instancia = new AdminDAOImplementation();
		return instancia;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void create(Admin admin) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(admin);
		session.getTransaction().commit();
		session.close();


	}
	@SuppressWarnings("unchecked")
	@Override
	public Admin read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Admin p = session.get(Admin.class, email);
		session.getTransaction().commit();
		session.close();
		return p;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void update(Admin admin) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(admin);
		session.getTransaction().commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	@Override
	public void delete(Admin admin) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(admin);
		session.getTransaction().commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Admin> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List <Admin> admins = session.createQuery("from Admin").list();
		session.getTransaction().commit();
		session.close();
		return admins;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Admin login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Admin p =null;
		Query q = session.createQuery("select p from Admin p where p.email = :email and p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Admin> admins = q.getResultList();
		if (admins.size() > 0)
			p = (Admin) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return p;
	}

}
