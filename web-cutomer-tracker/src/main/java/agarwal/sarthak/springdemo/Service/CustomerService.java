package agarwal.sarthak.springdemo.Service;

import java.util.List;

import agarwal.sarthak.springdemo.entity.Customer;

public interface CustomerService 
{
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
}
