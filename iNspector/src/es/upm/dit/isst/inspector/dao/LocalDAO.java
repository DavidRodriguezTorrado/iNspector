package es.upm.dit.isst.inspector.dao;

import java.util.Collection;

import es.upm.dit.isst.inspector.model.Local;

public interface LocalDAO {

	public void create(Local local);
	public int read1(String name);
	public Local read(String name);
	public void update(Local local);
	public void delete(String local);
	public Collection<Local> readAll();
	public Local read2(int id);
}
