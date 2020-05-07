package es.upm.dit.isst.inspector.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inspector.dao.FavoritoDAOImplementation;
import es.upm.dit.isst.inspector.dao.LocalDAOImplementation;
import es.upm.dit.isst.inspector.model.Customer;
import es.upm.dit.isst.inspector.model.Favorito;
import es.upm.dit.isst.inspector.model.Local;
/**
 * Servlet implementation class FormCreaInspector
 */
@WebServlet("/FormNuevoFavorito")
public class FormNuevoFavorito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormNuevoFavorito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = (String) req.getSession().getAttribute("Email");
		String rotulo = req.getParameter("rotulo");
		if(rotulo==null) {
			rotulo =(String)req.getSession().getAttribute("rotulo");
		}
		System.out.println(rotulo);
		System.out.println(email);
		
		Favorito fav = new Favorito();
		Customer cust = new Customer();
		Local loc = new Local();
		loc.setId(LocalDAOImplementation.getInstance().read1(rotulo));
		
		cust.setEmail(email);
		fav.setCustomer(cust);
		loc.setRotulo(rotulo);
		fav.setLocal(loc);
		
		FavoritoDAOImplementation.getInstance().create(fav);
		ArrayList<Integer> intInc =FavoritoDAOImplementation.getInstance().misFavoritos(email);
    	List <Favorito>  misFavoritos= new ArrayList<Favorito>();

		
		for (int i=1; i<=intInc.size(); i++){
			int n=intInc.get(i-1);
			Favorito inc= FavoritoDAOImplementation.getInstance().read1(n);
			misFavoritos.add(inc); 

		}
		req.getSession().setAttribute("misFavoritos", misFavoritos);
		req.getSession().setAttribute("favorito", FavoritoDAOImplementation.getInstance().read(email, rotulo));
		Customer customer = (Customer)req.getSession().getAttribute("customer");
		req.getSession().setAttribute("customer", customer);
		req.getSession().setAttribute("yaEsFavorito", "si");
		getServletContext().getRequestDispatcher("/Buscador-Usuario.jsp").forward(req,resp);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
