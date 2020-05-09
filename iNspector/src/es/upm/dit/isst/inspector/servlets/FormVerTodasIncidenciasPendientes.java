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

import es.upm.dit.isst.inspector.dao.InspectorDAOImplementation;
import es.upm.dit.isst.inspector.dao.CustomerDAOImplementation;
import es.upm.dit.isst.inspector.dao.IncidenciaDAOImplementation;
import es.upm.dit.isst.inspector.dao.LocalDAOImplementation;
import es.upm.dit.isst.inspector.model.Inspector;
import es.upm.dit.isst.inspector.model.Customer;
import es.upm.dit.isst.inspector.model.Local;
import es.upm.dit.isst.inspector.model.Incidencia;
/**
 * Servlet implementation class FormCreaInspector
 */
@WebServlet("/FormVerTodasIncidenciasPendientes")
public class FormVerTodasIncidenciasPendientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormVerTodasIncidenciasPendientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String email = (String) req.getSession().getAttribute("Email");
    	ArrayList<Integer> intInc =IncidenciaDAOImplementation.getInstance().misIncidenciasPorRevisar(email);
    	List <Incidencia>  misIncidencias= new ArrayList<Incidencia>();
		Inspector inspector = new Inspector();

		
		for (int i=1; i<=intInc.size(); i++){
			int n=intInc.get(i-1);
			Incidencia inc= IncidenciaDAOImplementation.getInstance().read(n);
			Local l =inc.getLocal();
			Local l2= LocalDAOImplementation.getInstance().read2(l.getId());
			inc.setLocal(l2);
			misIncidencias.add(inc); 

		}
		req.getSession().setAttribute("misIncidencias", misIncidencias);
    	
		inspector.setIncidenciasarevisar(misIncidencias);
		req.getSession().setAttribute("inspector", inspector);
    	getServletContext().getRequestDispatcher("/ListaDeIncidenciasPorRevisar.jsp").forward(req,resp);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(request, response);
    }

}
