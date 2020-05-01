package es.upm.dit.isst.inspector.dao;

import java.util.Collection;

import es.upm.dit.isst.inspector.model.Incidencia;

public interface IncidenciaDAO {

	public void create(Incidencia incidencia);
	public Incidencia read(int id);
	public void update(Incidencia incidencia);
	public void delete(Incidencia incidencia);
	public Collection<Incidencia> readAll();

}
