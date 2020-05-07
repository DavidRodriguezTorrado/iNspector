package es.upm.dit.isst.inspector.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inspector.dao.LocalDAOImplementation;
import es.upm.dit.isst.inspector.model.Local;


/**
 * Servlet implementation class FormCreaCustomer
 */
@WebServlet("/FormCreaLocal")
public class FormCreaLocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormCreaLocal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rotulo = req.getParameter("rotulo");
		String direccion = req.getParameter("direccion");
		String epigrafe = req.getParameter("epigrafe");
		
		Local local = new Local();
		local.setRotulo(rotulo);
		local.setDireccion(direccion);
		local.setEpigrafe(epigrafe);
		
		LocalDAOImplementation.getInstance().create(local);
		getServletContext().getRequestDispatcher("/Conf-Administrador.jsp").forward(req,resp);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
