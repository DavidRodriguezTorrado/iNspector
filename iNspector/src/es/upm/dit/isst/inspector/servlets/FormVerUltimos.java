package es.upm.dit.isst.inspector.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.upm.dit.isst.inspector.dao.UltimoDAOImplementation;
import es.upm.dit.isst.inspector.dao.CustomerDAOImplementation;
import es.upm.dit.isst.inspector.dao.FavoritoDAOImplementation;
import es.upm.dit.isst.inspector.dao.IncidenciaDAOImplementation;
import es.upm.dit.isst.inspector.dao.LocalDAOImplementation;
import es.upm.dit.isst.inspector.model.Ultimo;
import es.upm.dit.isst.inspector.model.Customer;
import es.upm.dit.isst.inspector.model.Favorito;
import es.upm.dit.isst.inspector.model.Local;
import es.upm.dit.isst.inspector.model.Incidencia;
/**
 * Servlet implementation class FormCreaInspector
 */
@WebServlet("/FormVerUltimos")
public class FormVerUltimos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormVerUltimos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String email = (String) req.getSession().getAttribute("Email");
       	ArrayList<Integer> intUlt =UltimoDAOImplementation.getInstance().misUltimos(email);
    	List <Ultimo>  misUltimos= new ArrayList<Ultimo>();
		Customer cust = new Customer();

		
		for (int i=1; i<=intUlt.size(); i++){
			int n=intUlt.get(i-1);
			Ultimo inc= UltimoDAOImplementation.getInstance().read1(n);
			Local l=inc.getLocal();
			Local l2= LocalDAOImplementation.getInstance().read2(l.getId());
			inc.setLocal(l2);
			misUltimos.add(inc); 

		}
		req.getSession().setAttribute("misUltimos", misUltimos);
cust.setUltimos(misUltimos);
		req.getSession().setAttribute("cust", cust);
		
    	getServletContext().getRequestDispatcher("/ListaDeUltimos.jsp").forward(req,resp);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(request, response);
    }

}
