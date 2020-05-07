package es.upm.dit.isst.inspector.dao;

import java.util.ArrayList;
import java.util.Collection;

import es.upm.dit.isst.inspector.model.Incidencia;
import es.upm.dit.isst.inspector.model.Local;

public interface IncidenciaDAO {

	public void create(Incidencia incidencia);
	public Incidencia read(int id);
	public void update(Incidencia incidencia);
	public void delete(Incidencia incidencia);
	public Collection<Incidencia> readAll();
	public Local readLocal(int id);
	public ArrayList<Integer> misIncidencias(String email);
	public ArrayList<Integer> misIncidenciasRevisadas(String email);
	public ArrayList<Integer> misIncidenciasPorRevisar(String email);



}
