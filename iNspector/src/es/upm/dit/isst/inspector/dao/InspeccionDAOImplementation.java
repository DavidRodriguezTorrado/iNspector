package es.upm.dit.isst.inspector.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.inspector.model.Customer;
import es.upm.dit.isst.inspector.model.Incidencia;
import es.upm.dit.isst.inspector.model.Inspeccion;
import es.upm.dit.isst.inspector.model.Inspector;
import es.upm.dit.isst.inspector.model.Local;

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
		String rotulo = inspeccion.getRotulo();
		String direccion = inspeccion.getDireccion();
		String actividad = inspeccion.getActividad();
		String fecha = inspeccion.getFecha();
		String tipoactuacion = inspeccion.getTipo_actuacion();
		String inspector = inspeccion.getInspector().getEmail();
		String perfilactividad ="";
		String estado = "";
		String frecuencia = "";
		

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			PreparedStatement ps = con.prepareStatement("INSERT INTO INSPECCIONES " +
			 		"(rotulo, direccion, actividad, fecha, tipo_actuacion, perfil_actividad, estado_sanitario, f_inspeccion ,inspector) " +
			 		"VALUES ('" + rotulo + "', '" + direccion + "', '" + actividad + "', '" + fecha + "', '" + tipoactuacion + "', '" + perfilactividad + "', '" + estado+ "', '" + frecuencia+ "', '" + inspector+ "')");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();


	}
	@SuppressWarnings("unchecked")
	@Override
	public Inspeccion read(int id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Inspeccion  insp = new Inspeccion();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			 ResultSet res = s.executeQuery("SELECT * FROM INSPECCIONES WHERE inspecciones_id= '" +id+"'");
			if(res.next()) {
				
				insp.setId(id);
				insp.setRotulo(res.getString(2));
				insp.setDireccion(res.getString(3));
				insp.setActividad(res.getString(4));
				insp.setFecha(res.getString(5));
				insp.setTipo_actuacion(res.getString(6));
				insp.setPerfil_actividad(res.getString(7));
				insp.setEstado_sanitario(res.getString(8));
				insp.setF_inspeccion(res.getString(9));
				Inspector inspector = new Inspector();
				inspector.setEmail(res.getString(10));
				insp.setInspector(inspector);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		session.getTransaction().commit();
		session.close();
		return insp;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void update(Inspeccion inspeccion) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		int id = inspeccion.getId();
		String rotulo = inspeccion.getRotulo();
		String direccion = inspeccion.getDireccion();
		String actividad = inspeccion.getActividad();
		String fecha = inspeccion.getFecha();
		String tipo = inspeccion.getTipo_actuacion();
		String perfil = inspeccion.getPerfil_actividad();
		String estado = inspeccion.getEstado_sanitario();
		String frecuencia = inspeccion.getF_inspeccion();
		Inspector inspector = inspeccion.getInspector();
		

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			PreparedStatement ps = con.prepareStatement("UPDATE inspecciones SET Rotulo='"+rotulo+"', Direccion='"+direccion+"', "
					+ "Actividad='"+actividad+"', Fecha='"+fecha+"'"
					+ ", Tipo_actuacion='"+tipo+"', Perfil_actividad='"+perfil+"', Estado_sanitario='"+estado+""
					+ "', F_inspeccion='"+frecuencia+"', Inspector='"+inspector+"'" 
					+ "WHERE inspecciones_id='"+id+"'");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	@Override
	public void delete(int id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			PreparedStatement ps = con.prepareStatement("DELETE FROM INSPECCIONES WHERE inspecciones_id= '" +id+"'");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
			String query = "SELECT DISTINCT rotulo FROM inspecciones WHERE rotulo like '%" + rotulo + "%' ORDER BY rotulo";

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
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		String rotulo = inspeccion.getRotulo();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con;
			String url = "jdbc:mysql://localhost:3306/test1?serverTimezone=UTC";
			String user = "dbadmin";
			String pw = "tortuga";	
			con = DriverManager.getConnection(url, user, pw);
			Statement s = con.createStatement();
			String query = "SELECT * FROM inspecciones WHERE rotulo = '" + rotulo + "' AND F_inspeccion!='' ORDER BY F_inspeccion";

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
		session.getTransaction().commit();
		session.close();
		return inspeccion;
	}
	
	public ArrayList<Integer> inspecciones(String rotulo){
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		ArrayList<Integer> inspecciones = new ArrayList<Integer>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con;
			String url = "jdbc:mysql://localhost:3306/test1?serverTimezone=UTC";
			String user = "dbadmin";
			String pw = "tortuga";	
			con = DriverManager.getConnection(url, user, pw);
			Statement s = con.createStatement();
			String query = "SELECT * FROM inspecciones WHERE rotulo = '" + rotulo + "' AND F_inspeccion!='' ORDER BY F_inspeccion";

			ResultSet res = s.executeQuery(query);
			while(res.next()) {
				inspecciones.add((res.getInt(1)));
			}
			con.close();

		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();	
		}
		session.getTransaction().commit();
		session.close();
		return inspecciones;
	}
	public ArrayList<Integer> misInspeccionesPorHacer(String email){
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		ArrayList<Integer> misInspecciones = new ArrayList<Integer>();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT DISTINCT inspecciones_id FROM INSPECCIONES WHERE inspector like '%" +email+"%' and F_inspeccion=''");
			while(res.next()) {
				misInspecciones.add((res.getInt(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return misInspecciones;
	}

	public ArrayList<Integer> misInspeccionesHechas(String email){
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		ArrayList<Integer> misInspecciones = new ArrayList<Integer>();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT DISTINCT inspecciones_id FROM INSPECCIONES WHERE inspector like '%" +email+"%' and F_inspeccion!=''" );
			while(res.next()) {
				misInspecciones.add((res.getInt(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return misInspecciones;
	}
	
	public ArrayList<Integer> misInspeccionesMasImportantes(){
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		ArrayList<Integer> misInspecciones = new ArrayList<Integer>();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT DISTINCT inspecciones_id FROM INSPECCIONES WHERE F_inspeccion!='Muy Alta'" );
			while(res.next()) {
				misInspecciones.add((res.getInt(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return misInspecciones;
	}
	
	
}
