package es.upm.dit.isst.inspector.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormLogoutServlet
 */
@WebServlet("/FormLogoutServlet")
public class FormLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormLogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getSession().removeAttribute("admin");
		req.getSession().removeAttribute("inspectores");
		req.getSession().removeAttribute("customers");
		req.getSession().removeAttribute("inspector");
		req.getSession().removeAttribute("customer");
		req.getSession().removeAttribute("rotulos");
		req.getSession().removeAttribute("Email");
		req.getSession().removeAttribute("Password");
		req.getSession().removeAttribute("Name");
		req.getSession().removeAttribute("Incidencia");
		req.getSession().removeAttribute("Fecha");
		req.getSession().removeAttribute("Local");
		req.getSession().removeAttribute("CustomerIncidencia");
		req.getSession().removeAttribute("InspectorIncidencia");
		req.getSession().removeAttribute("Inspected");
		req.getSession().setAttribute("Registrado", "no");
		req.getSession().removeAttribute("Comentarios");
		req.getSession().removeAttribute("Resultado");
		req.getSession().removeAttribute("rotulo");
		req.getSession().removeAttribute("inspeccion");
		req.getSession().removeAttribute("inspector");
		req.getSession().removeAttribute("Autorizado");
		req.getSession().removeAttribute("Inspeccion");
		req.getSession().removeAttribute("InspectorInspeccion");
		req.getSession().removeAttribute("Incidencia1");
		req.getSession().removeAttribute("Incidencia2");
		req.getSession().removeAttribute("Incidencia3");
		
              req.getSession().invalidate();
		getServletContext().getRequestDispatcher("/Principal.jsp").forward(req,resp);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
