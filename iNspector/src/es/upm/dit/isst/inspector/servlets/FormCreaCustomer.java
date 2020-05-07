package es.upm.dit.isst.inspector.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inspector.dao.CustomerDAOImplementation;
import es.upm.dit.isst.inspector.model.Customer;


/**
 * Servlet implementation class FormCreaCustomer
 */
@WebServlet("/FormCreaCustomer")
public class FormCreaCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormCreaCustomer() {
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
		
		Customer customer = new Customer();
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setName(name);
		
		CustomerDAOImplementation.getInstance().create(customer);
		req.getSession().setAttribute("customer", CustomerDAOImplementation.getInstance().read(customer.getEmail()));
		req.getSession().setAttribute("Name", customer.getName());
		req.getSession().setAttribute("Email", customer.getEmail());
		req.getSession().setAttribute("Password", customer.getPassword());
		req.getSession().setAttribute("Registrado", "si");
		getServletContext().getRequestDispatcher("/Conf-Usuario.jsp").forward(req,resp);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
