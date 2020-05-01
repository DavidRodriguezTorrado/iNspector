package es.upm.dit.isst.inspector.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

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
		session.save(inspector);
		session.getTransaction().commit();
		session.close();


	}
	@SuppressWarnings("unchecked")
	@Override
	public Inspector read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Inspector p = session.get(Inspector.class, email);
		session.getTransaction().commit();
		session.close();
		return p;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void update(Inspector inspector) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(inspector);
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
		Inspector p =null;
		Query q = session.createQuery("select p from Inspector p where p.email = :email and p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Inspector> inspectores = q.getResultList();
		if (inspectores.size() > 0)
			p = (Inspector) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return p;
	}

}
