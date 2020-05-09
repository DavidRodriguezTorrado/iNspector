package es.upm.dit.isst.inspector.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inspector.dao.IncidenciaDAOImplementation;
import es.upm.dit.isst.inspector.dao.LocalDAOImplementation;
import es.upm.dit.isst.inspector.model.Incidencia;
import es.upm.dit.isst.inspector.model.Local;


/**
 * Servlet implementation class FormCreaCustomer
 */
@WebServlet("/FormEditaIncidencia")
public class FormEditaIncidencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormEditaIncidencia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int id= (int) req.getSession().getAttribute("ID");
			String email= (String)req.getSession().getAttribute("Email");
	        String fecha= (String)req.getSession().getAttribute("Fecha");
	        String local = (String)req.getSession().getAttribute("LOCAL");
	        String customer= req.getSession().getAttribute("Customer").toString();
	        String inspected = "yes";
	        String comentarios= (String) req.getSession().getAttribute("Comentarios");
	        String resultado = req.getParameter("Resultado");
	        Incidencia inc= new Incidencia();
	        req.getSession().setAttribute("Local", LocalDAOImplementation.getInstance().read(local));;
			Local local2 = new Local();
			local2.setId(LocalDAOImplementation.getInstance().read1(local));
	        inc.setId(id);
	        inc.setFecha(fecha);
	        inc.setLocal(local2);
	        inc.setInspected(inspected);
	        inc.setComentarios(comentarios);
	        inc.setResultado(resultado);
	        
	        IncidenciaDAOImplementation.getInstance().update(inc);
	        ArrayList<Integer> incidenciasint= IncidenciaDAOImplementation.getInstance().misIncidenciasPorRevisar(email);
			System.out.println(incidenciasint);
			List<Incidencia> incidencias= new ArrayList<Incidencia>();
			
			for (int i=1; i<=incidenciasint.size(); i++){
				int n=incidenciasint.get(i-1);
				Incidencia inc1= IncidenciaDAOImplementation.getInstance().read(n);
				incidencias.add(inc1);

			}
			inc = IncidenciaDAOImplementation.getInstance().read(id);
			req.getSession().setAttribute("misIncidenciasRevisadas", incidencias);
	    	req.getSession().setAttribute("Incidencia", IncidenciaDAOImplementation.getInstance().read(inc.getId()));
	    	req.getSession().setAttribute("Fecha",inc.getFecha());
	    	
	    	req.getSession().setAttribute("Local",inc.getLocal().getRotulo());
	    	req.getSession().setAttribute("CustomerIncidencia",inc.getCustomer());
	    	req.getSession().setAttribute("InspectorIncidencia",inc.getInspector());
	    	req.getSession().setAttribute("Inspected",inc.getInspected());
	    	req.getSession().setAttribute("Comentarios",inc.getComentarios());
	    	req.getSession().setAttribute("Resultado",inc.getResultado());
	    	
	    	getServletContext().getRequestDispatcher("/ListadeIncidenciasPorRevisar.jsp").forward(req,resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
