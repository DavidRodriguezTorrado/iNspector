package es.upm.dit.isst.inspector.dao;

import java.util.Collection;

import es.upm.dit.isst.inspector.model.Local;

public interface LocalDAO {

	public void create(Local local);
	public Local read(String name);
	public void update(Local local);
	public void delete(Local local);
	public Collection<Local> readAll();

}
