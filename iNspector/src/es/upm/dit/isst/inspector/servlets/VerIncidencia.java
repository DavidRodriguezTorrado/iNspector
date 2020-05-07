package es.upm.dit.isst.inspector.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inspector.dao.CustomerDAOImplementation;
import es.upm.dit.isst.inspector.dao.IncidenciaDAOImplementation;
import es.upm.dit.isst.inspector.dao.LocalDAOImplementation;
import es.upm.dit.isst.inspector.model.Customer;
import es.upm.dit.isst.inspector.model.Incidencia;
import es.upm.dit.isst.inspector.model.Local;



/**
 * Servlet implementation class FormCreaCustomer
 */
@WebServlet("/VerIncidencia")
public class VerIncidencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerIncidencia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ident = req.getParameter("incidencia");
		int ident1 = Integer.parseInt(ident);
		String local = req.getParameter("local");
		
		Incidencia incidencia =IncidenciaDAOImplementation.getInstance().read(ident1);
		

		req.getSession().setAttribute("incidencia", incidencia);
		req.getSession().setAttribute("ID", incidencia.getId());
		req.getSession().setAttribute("Fecha", incidencia.getFecha());
		req.getSession().setAttribute("Local", local);
		req.getSession().setAttribute("Customer", incidencia.getCustomer().getEmail());
		req.getSession().setAttribute("Inspected", incidencia.getInspected());
		req.getSession().setAttribute("Comentarios", incidencia.getComentarios());
		req.getSession().setAttribute("Resultado", incidencia.getResultado());
		
		getServletContext().getRequestDispatcher("/MostrarIncidencia.jsp").forward(req,resp);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
