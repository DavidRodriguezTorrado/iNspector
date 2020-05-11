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
import es.upm.dit.isst.inspector.dao.LocalDAOImplementation;
import es.upm.dit.isst.inspector.model.Incidencia;
import es.upm.dit.isst.inspector.model.Local;


/**
 * Servlet implementation class FormCreaCustomer
 */
@WebServlet("/FormHacerInspeccion")
public class FormHacerInspeccion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormHacerInspeccion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*	int id= (int) req.getSession().getAttribute("ID");
			
			req.getSession().setAttribute("rotulo");
	        InspeccionAOImplementation.getInstance().update(inc);
	   
			
	
			inc = IncidenciaDAOImplementation.getInstance().read(id);
			req.getSession().setAttribute("misIncidenciasRevisadas", incidencias);
	    	req.getSession().setAttribute("Incidencia", IncidenciaDAOImplementation.getInstance().read(inc.getId()));
	    	req.getSession().setAttribute("Fecha",inc.getFecha());
	    	
	    	req.getSession().setAttribute("Local",inc.getLocal().getRotulo());
	    	req.getSession().setAttribute("CustomerIncidencia",inc.getCustomer());
	    	req.getSession().setAttribute("InspectorIncidencia",inc.getInspector());
	    	req.getSession().setAttribute("Inspected",inc.getInspected());
	    	req.getSession().setAttribute("Comentarios",inc.getComentarios());
	    	req.getSession().setAttribute("Resultado",inc.getResultado());
	    	*/
	    	getServletContext().getRequestDispatcher("/ListadeInspeccionesProgramadas.jsp").forward(req,resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
