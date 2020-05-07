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
	@Column(name="id")
	private int id;
	private String rotulo;
	private String direccion;
	private String epigrafe;

	
	@OneToMany(mappedBy = "local")
    private List<Favorito> customersfavoritos;
    
    @OneToMany(mappedBy = "local")
    private List<Ultimo> customersultimos;
	
	@OneToMany(mappedBy = "local")
	private List<Inspeccion> inspecciones;
	
	@OneToMany(mappedBy = "local")
	private Collection<Incidencia> incidencias;

	public Local() {

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRotulo() {
		return rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEpigrafe() {
		return epigrafe;
	}

	public void setEpigrafe(String epigrafe) {
		this.epigrafe = epigrafe;
	}

	public List<Favorito> getCustomersfavoritos() {
		return customersfavoritos;
	}

	public void setCustomersfavoritos(List<Favorito> customersfavoritos) {
		this.customersfavoritos = customersfavoritos;
	}

	public List<Ultimo> getCustomersultimos() {
		return customersultimos;
	}

	public void setCustomersultimos(List<Ultimo> customersultimos) {
		this.customersultimos = customersultimos;
	}

	public Collection<Inspeccion> getInspecciones() {
		return inspecciones;
	}

	public void setInspecciones(List<Inspeccion> inspecciones) {
		this.inspecciones = inspecciones;
	}

	public Collection<Incidencia> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(Collection<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((rotulo == null) ? 0 : rotulo.hashCode());
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
		int p=0;
		if (id != other.id)
			p++;
		if (rotulo == null) {
			if (other.rotulo != null)
				p++;
		} else if (!rotulo.equals(other.rotulo))
			return false;
		if(p==2)
		return false;
		return true;
	}

	@Override
	public String toString() {
		return "Local [id=" + id + ", rotulo=" + rotulo + ", direccion=" + direccion + ", epigrafe=" + epigrafe
				+ ", customersfavoritos=" + customersfavoritos + ", customersultimos="
				+ customersultimos + ", inspecciones=" + inspecciones + ", incidencias=" + incidencias + "]";
	}

}