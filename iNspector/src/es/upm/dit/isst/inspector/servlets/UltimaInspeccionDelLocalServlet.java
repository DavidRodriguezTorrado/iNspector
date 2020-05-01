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
import es.upm.dit.isst.inspector.dao.InspeccionDAOImplementation;
import es.upm.dit.isst.inspector.model.Inspeccion;
import es.upm.dit.isst.inspector.model.Customer;


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
		String rotulo = req.getParameter("rotulo");
		if(rotulo==null) {
			rotulo =(String)req.getSession().getAttribute("rotulo");
		}
		Inspeccion inspeccion = new Inspeccion();
		inspeccion.setRotulo(rotulo);
		String name =(String)req.getSession().getAttribute("Name");
		
		String reg=(String)req.getSession().getAttribute("Registrado");
		req.getSession().setAttribute("inspeccion", InspeccionDAOImplementation.getInstance().ultimaInspeccion(inspeccion));
		if(reg=="si" || reg=="no") {
		getServletContext().getRequestDispatcher("/Buscador-Usuario.jsp").forward(req,resp);
		}
		else if(reg=="inspector") {
			getServletContext().getRequestDispatcher("/Buscador-Inspector.jsp").forward(req, resp);

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
