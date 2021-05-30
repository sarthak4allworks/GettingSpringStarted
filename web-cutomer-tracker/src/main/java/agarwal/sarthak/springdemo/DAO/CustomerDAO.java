package agarwal.sarthak.springdemo.DAO;

import java.util.List;

import agarwal.sarthak.springdemo.entity.Customer;

public interface CustomerDAO 
{
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomr(int theId);
}
