package es.upm.dit.isst.inspector.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inspector.dao.IncidenciaDAOImplementation;
import es.upm.dit.isst.inspector.dao.InspeccionDAOImplementation;
import es.upm.dit.isst.inspector.dao.LocalDAOImplementation;
import es.upm.dit.isst.inspector.model.Customer;
import es.upm.dit.isst.inspector.model.Incidencia;
import es.upm.dit.isst.inspector.model.Inspeccion;
import es.upm.dit.isst.inspector.model.Local;


/**
 * Servlet implementation class FormCreaCustomer
 */
@WebServlet("/FormLocalesMasFrecuentes")
public class FormLocalesMasFrecuentes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormLocalesMasFrecuentes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = (String) req.getSession().getAttribute("Email");
    	ArrayList<Integer> intInc =InspeccionDAOImplementation.getInstance().misInspeccionesMasImportantes();
    	List <Inspeccion>  localesFrecuentes= new ArrayList<Inspeccion>();
	

		
		for (int i=1; i<=intInc.size(); i++){
			int n=intInc.get(i-1);
			Inspeccion inc= InspeccionDAOImplementation.getInstance().read(n);
		
			localesFrecuentes.add(inc); 

		}
		req.getSession().setAttribute("localesFrecuentes", localesFrecuentes);

		getServletContext().getRequestDispatcher("/ListaDeLocalesMasFrecuencia.jsp").forward(req,resp);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
