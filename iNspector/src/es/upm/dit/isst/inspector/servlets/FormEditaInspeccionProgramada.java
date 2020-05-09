package es.upm.dit.isst.inspector.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.inspector.dao.InspectorDAOImplementation;
import es.upm.dit.isst.inspector.dao.InspeccionDAOImplementation;
import es.upm.dit.isst.inspector.dao.LocalDAOImplementation;
import es.upm.dit.isst.inspector.model.Inspeccion;
import es.upm.dit.isst.inspector.model.Inspector;
import es.upm.dit.isst.inspector.model.Local;


/**
 * Servlet implementation class FormCreaCustomer
 */
@WebServlet("/FormEditaInspeccionProgramada")
public class FormEditaInspeccionProgramada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormEditaInspeccionProgramada() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = (String) req.getSession().getAttribute("Email");
		String rotulo = req.getParameter("rotulo");
		String fecha = req.getParameter("date");
		if(rotulo==null) {
			rotulo =(String)req.getSession().getAttribute("rotulo");
		}
		DateFormat format = new SimpleDateFormat("dd LL yyyy");
		
			//Date fecha = format.parse(req.getParameter("date"));

			//Date date = new Date();

			Inspector inspector = new Inspector();
			inspector.setEmail(email);
			String fecha1 = fecha.toString();
			
			Local local= LocalDAOImplementation.getInstance().read(rotulo);
			
			System.out.println(local);
			
			Inspeccion inspeccion = new Inspeccion();
			inspeccion.setInspector(inspector);
			inspeccion.setFecha(fecha1);
			inspeccion.setRotulo(local.getRotulo());
			inspeccion.setDireccion(local.getDireccion());
			inspeccion.setActividad(local.getEpigrafe());
			inspeccion.setTipo_actuacion("programada");
			
	
			if(LocalDAOImplementation.getInstance().read1(rotulo) >0){
			//if(LocalDAOImplementation.getInstance().read1(rotulo) >0 && fecha.after(date)){

				InspeccionDAOImplementation.getInstance().create(inspeccion);
				req.getSession().setAttribute("Inspeccion", InspeccionDAOImplementation.getInstance().read(inspeccion.getId()));
				System.out.println(InspeccionDAOImplementation.getInstance().read(inspeccion.getId()));
				req.getSession().setAttribute("InspectorInspeccion",inspector.getEmail());
				getServletContext().getRequestDispatcher("/BienProgramarInspeccion.jsp").forward(req,resp);
			}else{
				getServletContext().getRequestDispatcher("/ErrorProgramarInspeccion.jsp").forward(req,resp);

			}

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
