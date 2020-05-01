package es.upm.dit.isst.inspector.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inspector.dao.CustomerDAOImplementation;
import es.upm.dit.isst.inspector.dao.InspectorDAOImplementation;

import es.upm.dit.isst.inspector.model.Customer;
import es.upm.dit.isst.inspector.model.Inspector;


/**
 * Servlet implementation class Login
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String ADMIN_EMAIL = "root";
	private final String ADMIN_PASSWORD = "root";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		List<Customer> customers = (List<Customer>)CustomerDAOImplementation.getInstance().readAll();
		List<Inspector> inspectores = (List<Inspector>) InspectorDAOImplementation.getInstance().readAll();
		Inspector inspector = InspectorDAOImplementation.getInstance().login(email, password);
		Customer customer = CustomerDAOImplementation.getInstance().login(email, password);
		if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {
			req.getSession().setAttribute("admin", true);
			req.getSession().setAttribute("customers", customers);
			req.getSession().setAttribute("inspectores", inspectores);
			getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
		} else if ( null != customer ) {
			req.getSession().setAttribute("customer", CustomerDAOImplementation.getInstance().read(customer.getEmail()));
			getServletContext().getRequestDispatcher("/Conf-Usuario.jsp").forward(req,resp);
		} else if ( null != inspector ) {
			req.getSession().setAttribute("inspector", InspectorDAOImplementation.getInstance().read(inspector.getEmail()));
			getServletContext().getRequestDispatcher("/Profesor.jsp").forward(req,resp);
		} else {
			getServletContext().getRequestDispatcher("/MalLog.jsp").forward(req,resp);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
