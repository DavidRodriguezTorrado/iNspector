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
@WebServlet("/FormCreaIncidencia")
public class FormCreaIncidencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormCreaIncidencia() {
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
    	Date date = new Date();
    	DateFormat fecha1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fecha = fecha1.format(date);
		String comentarios = req.getParameter("comentarios");
		
		req.getSession().setAttribute("Local", LocalDAOImplementation.getInstance().read(rotulo));
		Customer customer2 = new Customer();
		customer2.setEmail(email);
		Inspector inspector2 = new Inspector();
		inspector2.setEmail(InspectorDAOImplementation.getInstance().seleccionar());
		Local local2 = new Local();
		local2.setId(LocalDAOImplementation.getInstance().read1(rotulo));
		


		System.out.println(customer2);

		System.out.println(inspector2);

		System.out.println(local2);
		System.out.println(rotulo);
		System.out.println(email);
		
		
    	Incidencia incidencia = new Incidencia();
    	incidencia.setFecha(fecha);
    	incidencia.setLocal(local2);
    	incidencia.setCustomer(customer2);
    	incidencia.setInspector(inspector2);
    	incidencia.setInspected("no");
    	incidencia.setComentarios(comentarios);
    	incidencia.setResultado("");


    	IncidenciaDAOImplementation.getInstance().create(incidencia);
    	ArrayList<Integer> incidenciasint= IncidenciaDAOImplementation.getInstance().misIncidencias(email);
		System.out.println(incidenciasint);
		List<Incidencia> incidencias= new ArrayList<Incidencia>();
		
		for (int i=1; i<=incidenciasint.size(); i++){
			int n=incidenciasint.get(i-1);
			Incidencia inc= IncidenciaDAOImplementation.getInstance().read(n);
			incidencias.add(inc); 

		}
		req.getSession().setAttribute("misIncidencias", incidencias);
    	req.getSession().setAttribute("Incidencia", IncidenciaDAOImplementation.getInstance().read(incidencia.getId()));
    	req.getSession().setAttribute("Fecha",incidencia.getFecha());
    	req.getSession().setAttribute("Local",incidencia.getLocal().getRotulo());
    	req.getSession().setAttribute("CustomerIncidencia",incidencia.getCustomer());
    	req.getSession().setAttribute("InspectorIncidencia",incidencia.getInspector());
    	req.getSession().setAttribute("Inspected",incidencia.getInspected());
    	req.getSession().setAttribute("Comentarios",incidencia.getComentarios());
    	req.getSession().setAttribute("Resultado",incidencia.getResultado());

    	getServletContext().getRequestDispatcher("/BienIncidencia.jsp").forward(req,resp);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(request, response);
    }

}
