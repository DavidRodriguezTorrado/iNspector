package es.upm.dit.isst.inspector.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="incidencias")
public class Incidencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private int id;
	private String fecha;


	@ManyToOne
	private Customer customer;

	@ManyToOne
	private Inspector inspector;
	private String inspected;
	private String comentarios;
	private String resultado;

	
	@ManyToOne
	private Local local;
	
	public Incidencia() {
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public String getFecha() {
		return fecha;
	}

	public Local getLocal() {
		return local;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public String getInspected() {
		return inspected;
	}

	public String getComentarios() {
		return comentarios;
	}

	public String getResultado() {
		return resultado;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setLocal(Local local) {
		this.local = local;
		
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}

	public void setInspected(String inspected) {
		this.inspected = inspected;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Incidencia [id=" + id + ", fecha=" + fecha + ", local=" + local + ", customer=" + customer
				+ ", inspector=" + inspector + ", inspected=" + inspected + ", comentarios=" + comentarios
				+ ", resultado=" + resultado + "]";
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
		Incidencia other = (Incidencia) obj;
		if (id != other.id)
			return false;
		return true;
	}


}
