package es.upm.dit.isst.inspector.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> buscador(String rotulo){
		List<String> rotulos = new ArrayList<String>();
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			String query = "SELECT DISTINCT rótulo FROM inspecciones_isst WHERE rótulo like '%" + rotulo + "%' ORDER BY rótulo";

			ResultSet res = s.executeQuery(query);

			while ( res.next() ) {
				rotulos.add(res.getString(1));
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return rotulos;
	}

	public Inspeccion ultimaInspeccion(Inspeccion inspeccion) {
		String rotulo = inspeccion.getRotulo();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con;
			String url = "jdbc:mysql://localhost:3306/test1?serverTimezone=UTC";
			String user = "dbadmin";
			String pw = "tortuga";	
			con = DriverManager.getConnection(url, user, pw);
			Statement s = con.createStatement();
			String query = "SELECT * FROM inspecciones_isst WHERE rótulo = '" + rotulo + "' ORDER BY Fecha_de_la_inspección";

			ResultSet res = s.executeQuery(query);
			if(res.next()) {
				inspeccion.setId(res.getInt(1));
				inspeccion.setRotulo(res.getString(2));
				inspeccion.setDireccion(res.getString(3));
				inspeccion.setActividad(res.getString(4));
				inspeccion.setFecha(res.getString(5));
				inspeccion.setTipo_actuacion(res.getString(6));
				inspeccion.setPerfil_actividad(res.getString(7));
				inspeccion.setEstado_sanitario(res.getString(8));
				inspeccion.setF_inspeccion(res.getString(9));

				con.close();
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();	
		}
		return inspeccion;
	}
}
