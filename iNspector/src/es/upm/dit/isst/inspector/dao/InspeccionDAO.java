package es.upm.dit.isst.inspector.dao;

import java.util.Collection;

import es.upm.dit.isst.inspector.model.Inspeccion;

public interface InspeccionDAO {

	public void create(Inspeccion inspeccion);
	public Inspeccion read(int id);
	public void update(Inspeccion inspeccion);
	public void delete(Inspeccion inspeccion);
	public Collection<Inspeccion> readAll();

}
