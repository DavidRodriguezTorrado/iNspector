package es.upm.dit.isst.inspector.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inspector.dao.FavoritoDAOImplementation;
import es.upm.dit.isst.inspector.dao.IncidenciaDAOImplementation;
import es.upm.dit.isst.inspector.dao.InspeccionDAOImplementation;
import es.upm.dit.isst.inspector.dao.LocalDAOImplementation;
import es.upm.dit.isst.inspector.dao.UltimoDAOImplementation;
import es.upm.dit.isst.inspector.model.Customer;
import es.upm.dit.isst.inspector.model.Favorito;
import es.upm.dit.isst.inspector.model.Incidencia;
import es.upm.dit.isst.inspector.model.Inspeccion;
import es.upm.dit.isst.inspector.model.Local;
import es.upm.dit.isst.inspector.model.Ultimo;

/**
 * Servlet implementation class Login
 */
@WebServlet("/UltimaInspeccionDelLocalServlet")
public class UltimaInspeccionDelLocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UltimaInspeccionDelLocalServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		String email = (String) req.getSession().getAttribute("Email");
		String rotulo = req.getParameter("rotulo");
		if(rotulo==null) {
			rotulo =(String)req.getSession().getAttribute("rotulo");
		}
		String reg= (String)req.getSession().getAttribute("Registrado");
		Local local = new Local();
		local.setRotulo(rotulo);
		if(reg=="si") {
			ArrayList<Integer> intInc =FavoritoDAOImplementation.getInstance().misFavoritos(email);
			List <Favorito>  misFavoritos= new ArrayList<Favorito>();
			Customer cust = new Customer();
			req.getSession().setAttribute("yaEsFavorito", "no");
			int prueba=0;
			for (int i=1; i<=intInc.size(); i++){
				int n=intInc.get(i-1);
				Favorito inc= FavoritoDAOImplementation.getInstance().read1(n);
				Local l=inc.getLocal();
				Local l2= LocalDAOImplementation.getInstance().read2(l.getId());
				if(l2.equals(local)) {
					prueba = 1;

				} 
				inc.setLocal(l2);
				misFavoritos.add(inc); 


			}
			
			if(prueba>0) {
				req.getSession().setAttribute("yaEsFavorito", "si");
			}
			
			Ultimo ultimo = new Ultimo();
			cust.setEmail(email);
			ultimo.setCustomer(cust);
			Date date = new Date();
	    	DateFormat fecha1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String fecha = fecha1.format(date);
			ultimo.setFecha(fecha);
			ultimo.setLocal(local);
	    	UltimoDAOImplementation.getInstance().create(ultimo);
			System.out.println("ESROM DN"+ultimo);

	    	ArrayList<Integer> intUlt= UltimoDAOImplementation.getInstance().misUltimos(email);
	    	List<Ultimo> misUltimos= new ArrayList<Ultimo>();
			
			for (int i=1; i<=intUlt.size(); i++){
				int n=intUlt.get(i-1);
				Ultimo inc= UltimoDAOImplementation.getInstance().read1(n);
				System.out.print(inc.getFecha());
				Local l=inc.getLocal();
				Local l2= LocalDAOImplementation.getInstance().read2(l.getId());
				inc.setLocal(l2);
				misUltimos.add(inc); 

			}
	    	

			
			System.out.println(prueba);
			System.out.println(misUltimos);
			System.out.println(req.getSession().getAttribute("yaEsFavorito"));
			System.out.println(misFavoritos);
			req.getSession().setAttribute("misFavoritos", misFavoritos);
			req.getSession().setAttribute("misUltimos", misUltimos);


			Favorito fav = new Favorito();
			fav.setLocal(local);

			cust.setFavoritos(misFavoritos);
			cust.setUltimos(misUltimos);
			req.getSession().setAttribute("cust", cust);
			
		/*	if(misFavoritos.contains(fav)){
				req.getSession().setAttribute("yaEsFavorito", "si");
				System.out.println("El código ya existe");
			}else{
				req.getSession().setAttribute("yaEsFavorito", "no");
			}*/
			System.out.println(req.getSession().getAttribute("yaEsFavorito"));
			}

		Inspeccion inspeccion = new Inspeccion();
		inspeccion.setRotulo(rotulo);
		String name =(String)req.getSession().getAttribute("Name");

		ArrayList<Integer> inspeccionesLocal= InspeccionDAOImplementation.getInstance().inspecciones(rotulo);
		List<Inspeccion> inspecciones= new ArrayList<Inspeccion>();


		for (int i=1; i<=inspeccionesLocal.size(); i++){
			int n=inspeccionesLocal.get(i-1);
			Inspeccion inc= InspeccionDAOImplementation.getInstance().read(n);
			inspecciones.add(inc); 

		}
		local.setInspecciones(inspecciones);
		req.getSession().setAttribute("misInspecciones", inspecciones);
		if(inspecciones.size()>=1) {
			req.getSession().setAttribute("Inspeccion1", inspecciones.get(0).getFecha());
			req.getSession().setAttribute("Inspeccion2", "0");
			req.getSession().setAttribute("Inspeccion3", "0");
			req.getSession().setAttribute("Inspeccion4", "0");

		}
		if(inspecciones.size()>=2) {
			req.getSession().setAttribute("Inspeccion2", inspecciones.get(1).getFecha());
			req.getSession().setAttribute("Inspeccion3", "0");
			req.getSession().setAttribute("Inspeccion4", "0");

		} if(inspecciones.size()>=3) {

			req.getSession().setAttribute("Inspeccion3", inspecciones.get(2).getFecha());
			req.getSession().setAttribute("Inspeccion4", "0");

		}  if(inspecciones.size()>=3) {

			req.getSession().setAttribute("Inspeccion4", inspecciones.get(3).getFecha());

		}

		req.getSession().setAttribute("rotulo", rotulo);
		req.getSession().setAttribute("inspeccion", InspeccionDAOImplementation.getInstance().ultimaInspeccion(inspeccion));
		if(reg=="si" || reg=="no") {
			getServletContext().getRequestDispatcher("/Buscador-Usuario.jsp").forward(req,resp);
		}
		else if(reg=="inspector" || reg=="inspector_noautorizado") {
			getServletContext().getRequestDispatcher("/Buscador-Inspector.jsp").forward(req, resp);

		}else if(reg=="admin") {
			getServletContext().getRequestDispatcher("/Buscador-Autoridad.jsp").forward(req, resp);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
