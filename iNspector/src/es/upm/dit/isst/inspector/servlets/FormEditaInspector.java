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
 * Servlet implementation class FormCreaCustomer
 */
@WebServlet("/FormEditaInspector")
public class FormEditaInspector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormEditaInspector() {
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
		
		Inspector inspector = new Inspector();
		inspector.setEmail(email);
		inspector.setPassword(password);
		inspector.setName(name);
		
		InspectorDAOImplementation.getInstance().update(inspector);
		req.getSession().setAttribute("inspector", InspectorDAOImplementation.getInstance().read(inspector.getEmail()));
		req.getSession().setAttribute("Name",inspector.getName());
		req.getSession().setAttribute("Email",inspector.getEmail());
		req.getSession().setAttribute("Password",inspector.getPassword());
		System.out.println(inspector);
		getServletContext().getRequestDispatcher("/BienEditado.jsp").forward(req,resp);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
