package es.upm.dit.isst.inspector.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inspector.dao.LocalDAOImplementation;

/**
 * Servlet implementation class FormLogoutServlet
 */
@WebServlet("/FormEliminarLocal")
public class FormEliminarLocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormEliminarLocal() {
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
		LocalDAOImplementation.getInstance().delete(rotulo);
		getServletContext().getRequestDispatcher("/Principal.jsp").forward(req,resp);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
