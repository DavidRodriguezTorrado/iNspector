package es.upm.dit.isst.inspector.dao;

import java.util.Collection;

import es.upm.dit.isst.inspector.model.Customer;

public interface CustomerDAO {

	public void create(Customer customer);
	public Customer read(String email);
	public void update(Customer customer);
	public void delete(Customer customer);
	public Collection<Customer> readAll();
	public Customer login(String email, String psd);
}
