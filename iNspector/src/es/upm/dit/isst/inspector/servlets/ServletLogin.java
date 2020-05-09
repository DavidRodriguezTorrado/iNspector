package es.upm.dit.isst.inspector.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inspector.dao.CustomerDAOImplementation;
import es.upm.dit.isst.inspector.dao.FavoritoDAOImplementation;
import es.upm.dit.isst.inspector.dao.IncidenciaDAOImplementation;
import es.upm.dit.isst.inspector.dao.InspeccionDAOImplementation;
import es.upm.dit.isst.inspector.dao.InspectorDAOImplementation;
import es.upm.dit.isst.inspector.dao.LocalDAOImplementation;
import es.upm.dit.isst.inspector.dao.UltimoDAOImplementation;
import es.upm.dit.isst.inspector.model.Admin;
import es.upm.dit.isst.inspector.model.Customer;
import es.upm.dit.isst.inspector.model.Favorito;
import es.upm.dit.isst.inspector.model.Incidencia;
import es.upm.dit.isst.inspector.model.Inspeccion;
import es.upm.dit.isst.inspector.model.Inspector;
import es.upm.dit.isst.inspector.model.Local;
import es.upm.dit.isst.inspector.model.Ultimo;

/**
 * Servlet implementation class Login
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String ADMIN_EMAIL = "root";
	private final String ADMIN_PASSWORD = "root";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Inspector inspector = InspectorDAOImplementation.getInstance().login(email, password);
		Customer customer = CustomerDAOImplementation.getInstance().login(email, password);
		System.out.println(customer);
		System.out.println(inspector);

		if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {
			req.getSession().setAttribute("admin", true);
			Admin admin = new Admin();
			List <Inspector> inspectores = new ArrayList<Inspector>(); 
			List<String> noautorizados = InspectorDAOImplementation.getInstance().inspectoresNoAutorizados();
			for (int i=1; i<=noautorizados.size(); i++){
				String n=noautorizados.get(i-1);
				Inspector insp= InspectorDAOImplementation.getInstance().read(n);
				inspectores.add(insp); 

			}
			admin.setInspectoresPorAutorizar(inspectores);
			req.getSession().setAttribute("Registrado", "admin");
			req.getSession().setAttribute("admin", admin);
			System.out.println(inspectores);
			req.getSession().setAttribute("noAutorizados", inspectores);
			getServletContext().getRequestDispatcher("/Conf-Administrador.jsp").forward(req,resp);
		} else if ( null != customer.getEmail() ) {
			req.getSession().setAttribute("customer", CustomerDAOImplementation.getInstance().read(customer.getEmail()));
			req.getSession().setAttribute("Name", customer.getName());
			req.getSession().setAttribute("Email", customer.getEmail());
			req.getSession().setAttribute("Password", customer.getPassword());
			System.out.println(customer.getEmail());
			ArrayList<Integer> incidenciasint= IncidenciaDAOImplementation.getInstance().misIncidencias(email);
			ArrayList<Integer> favoritosint= FavoritoDAOImplementation.getInstance().misFavoritos(email);
			ArrayList<Integer> ultimosint = UltimoDAOImplementation.getInstance().misUltimos(email);

			System.out.println(incidenciasint);
			List<Incidencia> incidencias= new ArrayList<Incidencia>();
			List<Favorito> favoritos= new ArrayList<Favorito>();
			List<Ultimo> ultimos= new ArrayList<Ultimo>();

			
			for (int i=1; i<=incidenciasint.size(); i++){
				int n=incidenciasint.get(i-1);
				Incidencia inc= IncidenciaDAOImplementation.getInstance().read(n);
				incidencias.add(inc); 

			}
			for (int i=1; i<=favoritosint.size(); i++){
				int n=favoritosint.get(i-1);
				Favorito inc= FavoritoDAOImplementation.getInstance().read1(n);
				Local l=inc.getLocal();
				Local l2= LocalDAOImplementation.getInstance().read2(l.getId());
				inc.setLocal(l2);
				favoritos.add(inc); 

			}
			
			for (int i=1; i<=ultimosint.size(); i++){
				int n=ultimosint.get(i-1);
				Ultimo inc= UltimoDAOImplementation.getInstance().read1(n);
				Local l=inc.getLocal();
				Local l2= LocalDAOImplementation.getInstance().read2(l.getId());
				inc.setLocal(l2);
				ultimos.add(inc); 

			}
			customer.setIncidencias(incidencias);
			customer.setUltimos(ultimos);
			customer.setFavoritos(favoritos);
			
			//System.out.println(incidencias.get(0));
			
			// INCIDENCIAS____________________
			req.getSession().setAttribute("misIncidencias", incidencias);
			req.getSession().setAttribute("Incidencia1", 0);
			req.getSession().setAttribute("IncidenciaLocal1","0");
			req.getSession().setAttribute("Incidencia2", 0);
			req.getSession().setAttribute("IncidenciaLocal2", 0);
			req.getSession().setAttribute("Incidencia3", 0);
			req.getSession().setAttribute("IncidenciaLocal3", 0);
			if(incidencias.size()>=1) {
				req.getSession().setAttribute("Incidencia1", incidencias.get(0).getId());
				req.getSession().setAttribute("IncidenciaLocal1", IncidenciaDAOImplementation.getInstance().readLocal(incidencias.get(0).getId()).getRotulo());
				req.getSession().setAttribute("Incidencia2", 0);
				req.getSession().setAttribute("IncidenciaLocal2", 0);
				req.getSession().setAttribute("Incidencia3", 0);
				req.getSession().setAttribute("IncidenciaLocal3", 0);

			}
			if(incidencias.size()>=2) {
				req.getSession().setAttribute("Incidencia2", incidencias.get(1).getId());
				req.getSession().setAttribute("IncidenciaLocal2", IncidenciaDAOImplementation.getInstance().readLocal(incidencias.get(1).getId()).getRotulo());
				req.getSession().setAttribute("Incidencia3", 0);
				req.getSession().setAttribute("IncidenciaLocal3", 0);

			} if(incidencias.size()>=3) {

				req.getSession().setAttribute("Incidencia3", incidencias.get(2).getId());
				req.getSession().setAttribute("IncidenciaLocal3", IncidenciaDAOImplementation.getInstance().readLocal(incidencias.get(2).getId()).getRotulo());

			}
			// FAVORITOS____________________

			req.getSession().setAttribute("misFavoritos", favoritos);
			req.getSession().setAttribute("Favorito1", 0);
			req.getSession().setAttribute("FavoritoLocal1", 0);
			req.getSession().setAttribute("Favorito2", 0);
			req.getSession().setAttribute("FavoritoLocal2", 0);
			req.getSession().setAttribute("Favorito3", 0);
			req.getSession().setAttribute("FavoritoLocal3", 0);

			if(favoritos.size()>=1) {
				req.getSession().setAttribute("Favorito1", favoritos.get(0).getId());
				req.getSession().setAttribute("FavoritoLocal1", favoritos.get(0).getLocal().getRotulo());
				req.getSession().setAttribute("Favorito2", 0);
				req.getSession().setAttribute("FavoritoLocal2", 0);
				req.getSession().setAttribute("Favorito3", 0);
				req.getSession().setAttribute("FavoritoLocal3", 0);

			}
			if(favoritos.size()>=2) {
				req.getSession().setAttribute("Favorito2", favoritos.get(1).getId());
				req.getSession().setAttribute("FavoritoLocal2", favoritos.get(1).getLocal().getRotulo());
				req.getSession().setAttribute("Favorito3", 0);
				req.getSession().setAttribute("FavoritoLocal3", 0);

			} if(favoritos.size()>=3) {

				req.getSession().setAttribute("Favorito3", favoritos.get(2).getId());
				req.getSession().setAttribute("FavoritoLocal3", favoritos.get(2).getLocal().getRotulo());

			}
			
			// ULTIMOS____________________
			req.getSession().setAttribute("misUltimos", ultimos);
			req.getSession().setAttribute("Ultimo1", 0);
			req.getSession().setAttribute("UltimoLocal1", 0);
			req.getSession().setAttribute("Ultimo2", 0);
			req.getSession().setAttribute("UltimoLocal2", 0);
			req.getSession().setAttribute("Ultimo3", 0);
			req.getSession().setAttribute("UltimoLocal3", 0);
			if(ultimos.size()>=1) {
				req.getSession().setAttribute("Ultimo1", ultimos.get(0).getId());
				req.getSession().setAttribute("UltimoLocal1", ultimos.get(0).getLocal().getRotulo());
				req.getSession().setAttribute("Ultimo2", 0);
				req.getSession().setAttribute("UltimoLocal2", 0);
				req.getSession().setAttribute("Ultimo3", 0);
				req.getSession().setAttribute("UltimoLocal3", 0);

			}
			if(ultimos.size()>=2) {
				req.getSession().setAttribute("Ultimo2", ultimos.get(1).getId());
				req.getSession().setAttribute("UltimoLocal2", ultimos.get(1).getLocal().getRotulo());
				req.getSession().setAttribute("Ultimo3", 0);
				req.getSession().setAttribute("UltimoLocal3", 0);

			} if(ultimos.size()>=3) {

				req.getSession().setAttribute("Ultimo3", ultimos.get(2).getId());
				req.getSession().setAttribute("UltimoLocal3", ultimos.get(2).getLocal().getRotulo());

			}
			
			customer.setIncidencias(incidencias);
			customer.setFavoritos(favoritos);
			customer.setUltimos(ultimos);
			req.getSession().setAttribute("Registrado", "si");
			getServletContext().getRequestDispatcher("/Conf-Usuario.jsp").forward(req,resp);
			
			
			
			
		} else if ( null != inspector.getEmail() ) {
			req.getSession().setAttribute("inspector", InspectorDAOImplementation.getInstance().read(inspector.getEmail()));
			req.getSession().setAttribute("Name", inspector.getName());
			req.getSession().setAttribute("Email", inspector.getEmail());
			req.getSession().setAttribute("Password", inspector.getPassword());
			req.getSession().setAttribute("Autorizado", inspector.getAutorizado());
			String autorizado = (String)req.getSession().getAttribute("Autorizado");
			System.out.println(autorizado);
			
			// INCIDENCIASPORRESVISAR____________________
			ArrayList<Integer> incidenciasint= IncidenciaDAOImplementation.getInstance().misIncidenciasPorRevisar(email);
			System.out.println(incidenciasint);
			List<Incidencia> incidenciasPorRevisar= new ArrayList<Incidencia>();
			
			for (int i=1; i<=incidenciasint.size(); i++){
				int n=incidenciasint.get(i-1);
				Incidencia inc= IncidenciaDAOImplementation.getInstance().read(n);
				Local l=inc.getLocal();
				Local l2= LocalDAOImplementation.getInstance().read2(l.getId());
				inc.setLocal(l2);
				incidenciasPorRevisar.add(inc); 

			}
			
			inspector.setIncidenciasarevisar(incidenciasPorRevisar);
			
			req.getSession().setAttribute("incidenciasPorRevisar", incidenciasPorRevisar);
			inspector.setIncidenciasarevisar(incidenciasPorRevisar);
			
			req.getSession().setAttribute("Incidencia1", 0);
			req.getSession().setAttribute("IncidenciaLocal1","0");
			req.getSession().setAttribute("Incidencia2", 0);
			req.getSession().setAttribute("IncidenciaLocal2", 0);
			req.getSession().setAttribute("Incidencia3", 0);
			req.getSession().setAttribute("IncidenciaLocal3", 0);
			if(incidenciasPorRevisar.size()>=1) {
				req.getSession().setAttribute("Incidencia1", incidenciasPorRevisar.get(0).getId());
				req.getSession().setAttribute("IncidenciaLocal1", IncidenciaDAOImplementation.getInstance().readLocal(incidenciasPorRevisar.get(0).getId()).getRotulo());
				req.getSession().setAttribute("Incidencia2", 0);
				req.getSession().setAttribute("IncidenciaLocal2", 0);
				req.getSession().setAttribute("Incidencia3", 0);
				req.getSession().setAttribute("IncidenciaLocal3", 0);

			}
			if(incidenciasPorRevisar.size()>=2) {
				req.getSession().setAttribute("Incidencia2", incidenciasPorRevisar.get(1).getId());
				req.getSession().setAttribute("IncidenciaLocal2", IncidenciaDAOImplementation.getInstance().readLocal(incidenciasPorRevisar.get(1).getId()).getRotulo());
				req.getSession().setAttribute("Incidencia3", 0);
				req.getSession().setAttribute("IncidenciaLocal3", 0);

			} if(incidenciasPorRevisar.size()>=3) {

				req.getSession().setAttribute("Incidencia3", incidenciasPorRevisar.get(2).getId());
				req.getSession().setAttribute("IncidenciaLocal3", IncidenciaDAOImplementation.getInstance().readLocal(incidenciasPorRevisar.get(2).getId()).getRotulo());

			}
		
			// INCIDENCIASRESVISADAS____________________
			ArrayList<Integer> incidenciasint2= IncidenciaDAOImplementation.getInstance().misIncidenciasRevisadas(email);
			System.out.println(incidenciasint2);
			List<Incidencia> incidenciasRevisadas= new ArrayList<Incidencia>();
			
			for (int i=1; i<=incidenciasint2.size(); i++){
				int n=incidenciasint2.get(i-1);
				Incidencia inc= IncidenciaDAOImplementation.getInstance().read(n);
				Local l=inc.getLocal();
				Local l2= LocalDAOImplementation.getInstance().read2(l.getId());
				inc.setLocal(l2);
				incidenciasRevisadas.add(inc); 

			}
			inspector.setIncidenciasrevisadas(incidenciasRevisadas);

			req.getSession().setAttribute("incidenciasRevisadas", incidenciasRevisadas);

			req.getSession().setAttribute("IncidenciaRevisada1", 0);
			req.getSession().setAttribute("IncidenciaLocalRevisada1","0");
			req.getSession().setAttribute("IncidenciaRevisada2", 0);
			req.getSession().setAttribute("IncidenciaLocalRevisada2", 0);
			req.getSession().setAttribute("IncidenciaRevisada3", 0);
			req.getSession().setAttribute("IncidenciaLocalRevisada3", 0);
			if(incidenciasRevisadas.size()>=1) {
				req.getSession().setAttribute("IncidenciaRevisada1", incidenciasRevisadas.get(0).getId());
				req.getSession().setAttribute("IncidenciaLocalRevisada1", IncidenciaDAOImplementation.getInstance().readLocal(incidenciasRevisadas.get(0).getId()).getRotulo());
				req.getSession().setAttribute("IncidenciaRevisada2", 0);
				req.getSession().setAttribute("IncidenciaLocalRevisada2", 0);
				req.getSession().setAttribute("IncidenciaRevisada3", 0);
				req.getSession().setAttribute("IncidenciaLocalRevisada3", 0);

			}
			if(incidenciasRevisadas.size()>=2) {
				req.getSession().setAttribute("IncidenciaRevisada2", incidenciasRevisadas.get(1).getId());
				req.getSession().setAttribute("IncidenciaLocalRevisada2", IncidenciaDAOImplementation.getInstance().readLocal(incidenciasRevisadas.get(1).getId()).getRotulo());
				req.getSession().setAttribute("IncidenciaRevisada3", 0);
				req.getSession().setAttribute("IncidenciaLocalRevisada3", 0);

			} if(incidenciasRevisadas.size()>=3) {

				req.getSession().setAttribute("IncidenciaRevisada3", incidenciasRevisadas.get(2).getId());
				req.getSession().setAttribute("IncidenciaLocalRevisada3", IncidenciaDAOImplementation.getInstance().readLocal(incidenciasRevisadas.get(2).getId()).getRotulo());

			}
			
			// INSPECCIONESPROGRAMADAS____________________
			ArrayList<Integer> inspeccionesint1= InspeccionDAOImplementation.getInstance().misInspeccionesPorHacer(email);
			
			List<Inspeccion> inspeccionesProgramadas= new ArrayList<Inspeccion>();
			
			for (int i=1; i<=inspeccionesint1.size(); i++){
				int n=inspeccionesint1.get(i-1);
				Inspeccion inc= InspeccionDAOImplementation.getInstance().read(n);
				inspeccionesProgramadas.add(inc); 

			}
			inspector.setInspeccionesprogramadas(inspeccionesProgramadas);

			req.getSession().setAttribute("inspeccionesProgramadas", inspeccionesProgramadas);

			req.getSession().setAttribute("InspeccionProgramada1", 0);
			req.getSession().setAttribute("InspeccionProgramadaLocal1","0");
			req.getSession().setAttribute("InspeccionProgramada2", 0);
			req.getSession().setAttribute("InspeccionProgramadaLocal2", 0);
			req.getSession().setAttribute("InspeccionProgramada3", 0);
			req.getSession().setAttribute("InspeccionProgramadaLocal3", 0);
			req.getSession().setAttribute("Fecha1", 0);
			req.getSession().setAttribute("Fecha2", 0);
			req.getSession().setAttribute("Fecha3", 0);
			if(inspeccionesProgramadas.size()>=1) {
				req.getSession().setAttribute("InspeccionProgramada1", inspeccionesProgramadas.get(0).getId());
				req.getSession().setAttribute("InspeccionProgramadaLocal1", inspeccionesProgramadas.get(0).getRotulo());
				req.getSession().setAttribute("Fecha1", inspeccionesProgramadas.get(0).getFecha());

			}
			if(inspeccionesProgramadas.size()>=2) {
				req.getSession().setAttribute("InspeccionProgramada2", inspeccionesProgramadas.get(1).getId());
				req.getSession().setAttribute("InspeccionProgramadaLocal2", inspeccionesProgramadas.get(1).getRotulo());
				req.getSession().setAttribute("Fecha2", inspeccionesProgramadas.get(1).getFecha());

			} if(inspeccionesProgramadas.size()>=3) {

				req.getSession().setAttribute("InspeccionProgramada3", inspeccionesProgramadas.get(2).getId());
				req.getSession().setAttribute("InspeccionProgramadaLocal3", inspeccionesProgramadas.get(2).getRotulo());
				req.getSession().setAttribute("Fecha3", inspeccionesProgramadas.get(2).getFecha());
			}
			
			
			
			
			// INSPECCIONESHechas____________________
			
	ArrayList<Integer> inspeccionesint2= InspeccionDAOImplementation.getInstance().misInspeccionesHechas(email);
			
			List<Inspeccion> inspeccionesHechas= new ArrayList<Inspeccion>();
			
			for (int i=1; i<=inspeccionesint2.size(); i++){
				int n=inspeccionesint2.get(i-1);
				Inspeccion inc= InspeccionDAOImplementation.getInstance().read(n);
				inspeccionesHechas.add(inc); 

			}
			inspector.setInspeccioneshechas(inspeccionesHechas);

			req.getSession().setAttribute("inspeccionesHechas", inspeccionesHechas);

			req.getSession().setAttribute("InspeccionHecha1", 0);
			req.getSession().setAttribute("InspeccionLocalHecha1","0");
			req.getSession().setAttribute("InspeccionHecha2", 0);
			req.getSession().setAttribute("InspeccionLocalHecha2", 0);
			req.getSession().setAttribute("InspeccionHecha3", 0);
			req.getSession().setAttribute("InspeccionLocalHechal3", 0);
			req.getSession().setAttribute("FechaHecha1", 0);
			req.getSession().setAttribute("FechaHecha2", 0);
			req.getSession().setAttribute("FechaHecha3", 0);
			if(inspeccionesHechas.size()>=1) {
				req.getSession().setAttribute("InspeccionHecha1", inspeccionesHechas.get(0).getId());
				req.getSession().setAttribute("InspeccionLocalHechal1", inspeccionesHechas.get(0).getRotulo());
				req.getSession().setAttribute("Fecha1Hecha", inspeccionesHechas.get(0).getFecha());

			}
			if(inspeccionesHechas.size()>=2) {
				req.getSession().setAttribute("InspeccionHecha2", inspeccionesHechas.get(1).getId());
				req.getSession().setAttribute("InspeccionLocalHecha2", inspeccionesHechas.get(1).getRotulo());
				req.getSession().setAttribute("Fecha2Hecha", inspeccionesHechas.get(1).getFecha());

			} if(inspeccionesHechas.size()>=3) {

				req.getSession().setAttribute("InspeccionHecha3", inspeccionesHechas.get(2).getId());
				req.getSession().setAttribute("InspeccionLocalHecha3", inspeccionesHechas.get(2).getRotulo());
				req.getSession().setAttribute("Fecha3Hecha", inspeccionesHechas.get(2).getFecha());
			}
			
			
			
			req.getSession().setAttribute("Registrado", "inspector");	
				if(autorizado == "no") {
					req.getSession().setAttribute("Registrado", "inspector_noautorizado");
			}
			getServletContext().getRequestDispatcher("/Conf-Inspector.jsp").forward(req,resp);
		} else {
			getServletContext().getRequestDispatcher("/MalLog.jsp").forward(req,resp);
			req.getSession().setAttribute("Registrado", "no");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
