package es.upm.dit.isst.inspector.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import es.upm.dit.isst.inspector.model.Inspeccion;
import es.upm.dit.isst.inspector.model.Inspector;

class InspeccionDAOImplementationTest {

	@Test
	void testCreate() {
		InspeccionDAO inspecciondao = InspeccionDAOImplementation.getInstance();
		Inspeccion inspeccion = new Inspeccion();
		Inspector inspector = new Inspector();
		inspector.setEmail("pruebaemail");
		inspector.setName("pruebaname");
		inspector.setPassword("pruebapassword");
		inspector.setAutorizado("si");
		inspeccion.setId(9999);
		inspeccion.setRotulo("pruebarotulo");
		inspeccion.setDireccion("pruebadireccion");
		inspeccion.setActividad("pruebaactividad");
		inspeccion.setFecha("01/01/1990");
		inspeccion.setTipo_actuacion("pruebaactuacion");
		inspeccion.setPerfil_actividad("pruebaperfil");
		inspeccion.setEstado_sanitario("pruebarotulo");
		inspeccion.setF_inspeccion("pruebafrecuencia");
		inspeccion.setInspector(inspector);
		inspecciondao.create(inspeccion);
		//assertEquals(inspecciondao.read(9999).getRotulo(), "pruebarotulo");
		assertEquals("pruebarotulo", inspecciondao.read(9999).getRotulo());
		inspecciondao.delete(inspeccion);		
		
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testBuscador() {
		fail("Not yet implemented");
	}

	@Test
	void testUltimaInspeccion() {
		fail("Not yet implemented");
	}

}
