package es.upm.dit.isst.inspector.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inspector.dao.InspectorDAOImplementation;
import es.upm.dit.isst.inspector.model.Inspector;
import es.upm.dit.isst.inspector.model.Admin;



/**
 * Servlet implementation class FormCreaCustomer
 */
@WebServlet("/FormAutorizar")
public class FormAutorizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormAutorizar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		InspectorDAOImplementation.getInstance().autorizar(email);
		Admin admin = new Admin();
		List <Inspector> inspectores = new ArrayList <Inspector>(); 
		List<String> noautorizados = InspectorDAOImplementation.getInstance().inspectoresNoAutorizados();
		for (int i=1; i<=noautorizados.size(); i++){
			String n=noautorizados.get(i-1);
			Inspector insp= InspectorDAOImplementation.getInstance().read(n);
			inspectores.add(insp); 

		}
		admin.setInspectoresPorAutorizar(inspectores);
		req.getSession().setAttribute("Registrado", "admin");
		req.getSession().setAttribute("admin", admin);
		System.out.println(inspectores);
		req.getSession().setAttribute("noAutorizados", inspectores);
		
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
