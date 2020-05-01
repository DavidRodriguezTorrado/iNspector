package es.upm.dit.isst.inspector.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.inspector.model.Inspeccion;

public class InspeccionDAOImplementation implements InspeccionDAO {

	private static  InspeccionDAOImplementation instancia = null;
	
	private InspeccionDAOImplementation() {
	}

	public static InspeccionDAOImplementation getInstance() {
		if( null == instancia ) 
			instancia = new InspeccionDAOImplementation();
		return instancia;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void create(Inspeccion inspeccion) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(inspeccion);
		session.getTransaction().commit();
		session.close();


	}
	@SuppressWarnings("unchecked")
	@Override
	public Inspeccion read(int id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Inspeccion p = session.get(Inspeccion.class, id);
		session.getTransaction().commit();
		session.close();
		return p;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void update(Inspeccion inspeccion) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(inspeccion);
		session.getTransaction().commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	@Override
	public void delete(Inspeccion inspeccion) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(inspeccion);
		session.getTransaction().commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Inspeccion> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List <Inspeccion> inspecciones = session.createQuery("from Inspeccion").list();
		session.getTransaction().commit();
		session.close();
		return inspecciones;
	}

}
