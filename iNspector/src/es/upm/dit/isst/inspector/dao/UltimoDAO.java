package es.upm.dit.isst.inspector.dao;

import java.util.ArrayList;

import es.upm.dit.isst.inspector.model.Ultimo;

public interface UltimoDAO {

	public void create(Ultimo ultimo);
	public Ultimo read(String email, String rotulo);
	public void delete(int id);
	public ArrayList<Integer> misUltimos(String email);
	public Ultimo read1(int id);
}
