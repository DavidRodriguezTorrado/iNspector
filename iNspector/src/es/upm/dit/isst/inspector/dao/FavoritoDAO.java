package es.upm.dit.isst.inspector.dao;


import java.util.ArrayList;

import es.upm.dit.isst.inspector.model.Favorito;

public interface FavoritoDAO {

	public void create(Favorito favorito);
	public void delete(String email, String rotulo);
	public ArrayList<Integer> misFavoritos(String email);
	public Favorito read(String email, String rotulo);
	public Favorito read1(int id);
}
