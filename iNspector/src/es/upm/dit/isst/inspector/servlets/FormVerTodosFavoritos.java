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
@WebServlet("/FormVerTodosFavoritos")
public class FormVerTodosFavoritos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormVerTodosFavoritos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String email = (String) req.getSession().getAttribute("Email");
    	ArrayList<Integer> intInc =FavoritoDAOImplementation.getInstance().misFavoritos(email);
    	List <Favorito>  misFavoritos= new ArrayList<Favorito>();
		Customer cust = new Customer();

		for (int i=1; i<=intInc.size(); i++){
			int n=intInc.get(i-1);
			Favorito inc= FavoritoDAOImplementation.getInstance().read1(n);
			Local l=inc.getLocal();
			Local l2= LocalDAOImplementation.getInstance().read2(l.getId());
			inc.setLocal(l2);
			misFavoritos.add(inc); 

		}
		req.getSession().setAttribute("misFavoritos", misFavoritos);
    	
		cust.setFavoritos(misFavoritos);
		req.getSession().setAttribute("cust", cust);
		System.out.println(misFavoritos);
    	getServletContext().getRequestDispatcher("/ListaDeFavoritos.jsp").forward(req,resp);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(request, response);
    }

}
