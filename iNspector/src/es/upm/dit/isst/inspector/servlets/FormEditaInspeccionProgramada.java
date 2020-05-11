package es.upm.dit.isst.inspector.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inspector.dao.InspeccionDAOImplementation;
import es.upm.dit.isst.inspector.model.Inspeccion;


/**
 * Servlet implementation class FormCreaCustomer
 */
@WebServlet("/FormEditaInspeccionProgramada")
public class FormEditaInspeccionProgramada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormEditaInspeccionProgramada() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = (int) req.getSession().getAttribute("id");
		Inspeccion inspeccion= InspeccionDAOImplementation.getInstance().read(id);
		
		getServletContext().getRequestDispatcher("/EditarInspeccion.jsp").forward(req,resp);

			

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
