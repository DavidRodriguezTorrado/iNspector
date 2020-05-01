package es.upm.dit.isst.inspector.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inspector.dao.InspectorDAOImplementation;
import es.upm.dit.isst.inspector.model.Inspector;

/**
 * Servlet implementation class FormCreaInspector
 */
@WebServlet("/FormCreaInspector")
public class FormCreaInspector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormCreaInspector() {
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
		String autorizado = "no";
		
		Inspector inspector = new Inspector();
		inspector.setEmail(email);
		inspector.setPassword(password);
		inspector.setName(name);
		inspector.setAutorizado(autorizado);
		
		InspectorDAOImplementation.getInstance().create(inspector);
		req.getSession().setAttribute("inspector", InspectorDAOImplementation.getInstance().read(inspector.getEmail()));
		req.getSession().setAttribute("Registrado", "inspector_noautorizado");
		getServletContext().getRequestDispatcher("/Conf-Inspector.jsp").forward(req,resp);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
