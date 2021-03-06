package es.upm.dit.isst.inspector.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="email")
	private String email;
	private String name;
	private String password;
	
	@OneToMany(mappedBy = "customer")
	private List<Incidencia> incidencias;

    @OneToMany(mappedBy = "customer")
	private List<Favorito> favoritos;

    @OneToMany(mappedBy= "customer")
	private List<Ultimo> ultimos;

	public Customer() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Customer other = (Customer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public List<Incidencia> getIncidencias() {
		return incidencias;
	}

	public List<Favorito> getFavoritos() {
		return favoritos;
	}

	public List<Ultimo> getUltimos() {
		return ultimos;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setIncidencias(List<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}

	public void setFavoritos(List<Favorito> favoritos) {
		this.favoritos = favoritos;
	}

	public void setUltimos(List<Ultimo> ultimos) {
		this.ultimos = ultimos;
	}

	@Override
	public String toString() {
		return "Customer [email=" + email + ", name=" + name + ", password=" + password + "]";
	}


}


