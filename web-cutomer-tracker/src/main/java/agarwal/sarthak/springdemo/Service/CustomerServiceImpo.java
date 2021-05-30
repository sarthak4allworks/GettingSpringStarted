package agarwal.sarthak.springdemo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agarwal.sarthak.springdemo.DAO.CustomerDAO;
import agarwal.sarthak.springdemo.entity.Customer;

@Service
public class CustomerServiceImpo implements CustomerService 
{
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers()
	{
		return customerDAO.getCustomers();
	}

}
