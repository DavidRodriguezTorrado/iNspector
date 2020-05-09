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
import es.upm.dit.isst.inspector.dao.LocalDAOImplementation;
import es.upm.dit.isst.inspector.dao.UltimoDAOImplementation;
import es.upm.dit.isst.inspector.model.Customer;
import es.upm.dit.isst.inspector.model.Favorito;
import es.upm.dit.isst.inspector.model.Incidencia;
import es.upm.dit.isst.inspector.model.Local;
import es.upm.dit.isst.inspector.model.Ultimo;


/**
 * Servlet implementation class FormCreaCustomer
 */
@WebServlet("/FormCreaCustomer")
public class FormCreaCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormCreaCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		
		Customer customer = new Customer();
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setName(name);
		
		CustomerDAOImplementation.getInstance().create(customer);
		req.getSession().setAttribute("customer", CustomerDAOImplementation.getInstance().read(customer.getEmail()));
		req.getSession().setAttribute("Name", customer.getName());
		req.getSession().setAttribute("Email", customer.getEmail());
		req.getSession().setAttribute("Password", customer.getPassword());
		req.getSession().setAttribute("Registrado", "si");
		
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
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
