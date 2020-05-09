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

import org.hibernate.Session;

import es.upm.dit.isst.inspector.model.Customer;
import es.upm.dit.isst.inspector.model.Incidencia;
import es.upm.dit.isst.inspector.model.Inspector;
import es.upm.dit.isst.inspector.model.Local;
import es.upm.dit.isst.inspector.dao.LocalDAOImplementation;

public class IncidenciaDAOImplementation implements IncidenciaDAO {

	private static  IncidenciaDAOImplementation instancia = null;
	
	private IncidenciaDAOImplementation() {
	}

	public static IncidenciaDAOImplementation getInstance() {
		if( null == instancia ) 
			instancia = new IncidenciaDAOImplementation();
		return instancia;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void create(Incidencia incidencia) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		String fecha = incidencia.getFecha();
		Local local = incidencia.getLocal();
		int local1 = local.getId();
		Customer customer = incidencia.getCustomer();
		String customer1 = customer.getEmail();
		Inspector inspector = incidencia.getInspector();
		String inspector1 = inspector.getEmail();
		String inspected = incidencia.getInspected();
		String comentarios = incidencia.getComentarios();
		String resultado = incidencia.getResultado();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			PreparedStatement ps = con.prepareStatement("INSERT INTO INCIDENCIAS " +
			 		"(fecha, local, customer, inspector, inspected, comentarios, resultado) " +
			 		"VALUES ('" + fecha + "', '" + local1 + "', '" + customer1 + "', '" + inspector1 + "', '" + inspected + "', '" + comentarios + "', '" + resultado+ "')");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();


	}
	@SuppressWarnings("unchecked")
	@Override
	public Incidencia read(int id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Incidencia inc = new Incidencia();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			 ResultSet res = s.executeQuery("SELECT * FROM INCIDENCIAS WHERE id= '" +id+"'");
			if(res.next()) {
				
				inc.setId(res.getInt(1));
				inc.setFecha(res.getString(2));
				Local local = new Local();
				local.setId(res.getInt(3));
				inc.setLocal(local);
				Customer customer = new Customer();
				customer.setEmail(res.getString(4));	
				inc.setCustomer(customer);
				Inspector inspector = new Inspector();
				inspector.setEmail(res.getString(5));
				inc.setInspector(inspector);
				inc.setInspected(res.getString(6));
				inc.setComentarios(res.getString(7));
				inc.setResultado(res.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		session.getTransaction().commit();
		session.close();
		return inc;
	}
	
	public Local readLocal(int id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Local local1 = new Local();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT Local FROM INCIDENCIAS WHERE id= '" +id+"'");
			if(res.next()) {
				local1=	LocalDAOImplementation.getInstance().read2(res.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		session.getTransaction().commit();
		session.close();
		return local1;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(Incidencia incidencia) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		int id = incidencia.getId();
		String fecha = incidencia.getFecha();	
		Inspector inspector = incidencia.getInspector();
		String inspected = "yes";
		String comentarios = incidencia.getComentarios();
		String resultado = incidencia.getResultado();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			PreparedStatement ps = con.prepareStatement("UPDATE incidencias SET  inspected='"+inspected+"', resultado='"+resultado+"'WHERE id='"+id+"'");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	@Override
	public void delete(Incidencia incidencia) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(incidencia);
		session.getTransaction().commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Incidencia> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List <Incidencia> incidencias = session.createQuery("from Incidencia").list();
		session.getTransaction().commit();
		session.close();
		return incidencias;
	}
	
	public ArrayList<Integer> misIncidencias(String email){
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		ArrayList<Integer> misIncidencias = new ArrayList<Integer>();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT DISTINCT ID FROM INCIDENCIAS WHERE customer like '%" +email+"%'");
			while(res.next()) {
				misIncidencias.add((res.getInt(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return misIncidencias;
	}
	
	public ArrayList<Integer> misIncidenciasRevisadas(String email){
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		ArrayList<Integer> misIncidencias = new ArrayList<Integer>();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT DISTINCT ID FROM INCIDENCIAS WHERE inspector like '%" +email+"%' and inspected='yes'");
			while(res.next()) {
				misIncidencias.add((res.getInt(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return misIncidencias;
	}

	public ArrayList<Integer> misIncidenciasPorRevisar(String email){
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		ArrayList<Integer> misIncidencias = new ArrayList<Integer>();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1?serverTimezone=UTC", "dbadmin", "tortuga");;
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT DISTINCT ID FROM INCIDENCIAS WHERE inspector like '%" +email+"%' and inspected='no'" );
			while(res.next()) {
				misIncidencias.add((res.getInt(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		return misIncidencias;
	}
}
