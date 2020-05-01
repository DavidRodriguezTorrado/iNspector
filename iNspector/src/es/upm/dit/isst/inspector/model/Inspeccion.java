package es.upm.dit.isst.inspector.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="inspecciones")
public class Inspeccion {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private int id;
	private String rotulo;
	private String direccion;
	private String actividad;
	private String fecha;
	private String tipo_actuacion;
	private String perfil_actividad;
	private String estado_sanitario;
	private String f_inspeccion;
	
	@ManyToOne
	private Inspector inspector;
	
	@ManyToOne
	private Local local;


	public Inspeccion() {

	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getId() {
		return id;
	}


	public String getRotulo() {
		return rotulo;
	}


	public String getDireccion() {
		return direccion;
	}


	public String getActividad() {
		return actividad;
	}


	public String getFecha() {
		return fecha;
	}


	public String getTipo_actuacion() {
		return tipo_actuacion;
	}


	public String getPerfil_actividad() {
		return perfil_actividad;
	}


	public String getEstado_sanitario() {
		return estado_sanitario;
	}


	public String getF_inspeccion() {
		return f_inspeccion;
	}


	public Inspector getInspector() {
		return inspector;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public void setActividad(String actividad) {
		this.actividad = actividad;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public void setTipo_actuacion(String tipo_actuacion) {
		this.tipo_actuacion = tipo_actuacion;
	}


	public void setPerfil_actividad(String perfil_actividad) {
		this.perfil_actividad = perfil_actividad;
	}


	public void setEstado_sanitario(String estado_sanitario) {
		this.estado_sanitario = estado_sanitario;
	}


	public void setF_inspeccion(String f_inspeccion) {
		this.f_inspeccion = f_inspeccion;
	}


	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}


	@Override
	public String toString() {
		return "Inspeccion [id=" + id + ", rotulo=" + rotulo + ", direccion=" + direccion + ", actividad=" + actividad
				+ ", fecha=" + fecha + ", tipo_actuacion=" + tipo_actuacion + ", perfil_actividad=" + perfil_actividad
				+ ", estado_sanitario=" + estado_sanitario + ", f_inspeccion=" + f_inspeccion + ", inspector="
				+ inspector + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Inspeccion other = (Inspeccion) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
