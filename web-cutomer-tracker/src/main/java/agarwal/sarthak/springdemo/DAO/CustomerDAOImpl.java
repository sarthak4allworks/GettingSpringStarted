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
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomr(int theId) 
	{
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now read from the database usingprimary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) 
	{
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("delete from Customer where id=:theCustomerId");
		theQuery.setParameter("theCustomerId", theId);
		theQuery.executeUpdate();
	}
}
