package es.upm.dit.isst.inspector.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="admin")
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="email")
	private String email;
	private String password;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@OneToMany(mappedBy = "inspector")
	private List<Inspector> inspectoresPorAutorizar;
	
	public List<Inspector> getInspectoresPorAutorizar() {
		return inspectoresPorAutorizar;
	}


	public Admin() {

	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setInspectoresPorAutorizar(List<Inspector> inspectoresPorAutorizar) {
		this.inspectoresPorAutorizar = inspectoresPorAutorizar;
	}


	@Override
	public String toString() {
		return "Admin [email=" + email + ", password=" + password + ", inspectoresPorAutorizar=" + inspectoresPorAutorizar
				+ "]";
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
		Admin other = (Admin) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

}