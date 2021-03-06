package es.upm.dit.isst.inspector.dao;

import java.util.ArrayList;
import java.util.Collection;

import es.upm.dit.isst.inspector.model.Customer;
import es.upm.dit.isst.inspector.model.Inspector;

public interface InspectorDAO {

	public void create(Inspector inspector);
	public Inspector read(String email);
	public void update(Inspector inspector);
	public void delete(Inspector inspector);
	public void autorizar(String email);
	public Collection<Inspector> readAll();
	public Inspector login(String email, String psd);
	public String seleccionar();
	public ArrayList<String> inspectoresNoAutorizados();
}
