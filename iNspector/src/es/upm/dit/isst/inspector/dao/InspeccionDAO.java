package es.upm.dit.isst.inspector.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import es.upm.dit.isst.inspector.model.Inspeccion;

public interface InspeccionDAO {

	public void create(Inspeccion inspeccion);
	public Inspeccion read(int id);
	public void update(Inspeccion inspeccion);
	public void delete(Inspeccion inspeccion);
	public Collection<Inspeccion> readAll();
	public List<String> buscador(String rotulo);
	public Inspeccion ultimaInspeccion(Inspeccion inspeccion);
	public ArrayList<Integer> inspecciones(String rotulo);
	public ArrayList<Integer> misInspeccionesHechas(String email);
	public ArrayList<Integer> misInspeccionesPorHacer(String email);


}
