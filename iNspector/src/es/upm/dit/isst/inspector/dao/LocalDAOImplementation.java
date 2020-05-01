package es.upm.dit.isst.inspector.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

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
		session.save(local);
		session.getTransaction().commit();
		session.close();


	}
	@SuppressWarnings("unchecked")
	@Override
	public Local read(String name) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Local p = session.get(Local.class, name);
		session.getTransaction().commit();
		session.close();
		return p;
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
	public void delete(Local local) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(local);
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
