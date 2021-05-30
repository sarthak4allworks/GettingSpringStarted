package agarwal.sarthak.springdemo.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import agarwal.sarthak.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() 
	{
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query .. sort by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",
																Customer.class);
		
		// get list of customers from query
		List<Customer> customers = theQuery.getResultList();
		
		// return the list of the customers
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) 
	{
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer to the database
		currentSession.save(theCustomer);
	}
}
