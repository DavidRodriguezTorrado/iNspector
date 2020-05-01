package es.upm.dit.isst.inspector.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="locales")
public class Local implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="name")
	private String name;
	private String direccion;
	private String actividad;

	@ManyToOne
	private Customer customer;
	
    @ManyToMany(mappedBy = "favoritos")
    private Collection<Customer> customersfavoritos;
    
    @ManyToMany(mappedBy = "ultimos")
    private Collection<Customer> customersultimos;
	
	@OneToMany(mappedBy = "local")
	private Collection<Inspeccion> inspecciones;
	@OneToMany(mappedBy = "local")
	private Collection<Incidencia> incidencias;

	public Local() {

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getActividad() {
		return actividad;
	}

	public Collection<Inspeccion> getInspecciones() {
		return inspecciones;
	}

	public Collection<Incidencia> getIncidencias() {
		return incidencias;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public void setInspecciones(Collection<Inspeccion> inspecciones) {
		this.inspecciones = inspecciones;
	}

	public void setIncidencias(Collection<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}

	@Override
	public String toString() {
		return "Local [name=" + name + ", direccion=" + direccion + ", actividad=" + actividad + ", inspecciones="
				+ inspecciones + ", incidencias=" + incidencias + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Local other = (Local) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



}


	