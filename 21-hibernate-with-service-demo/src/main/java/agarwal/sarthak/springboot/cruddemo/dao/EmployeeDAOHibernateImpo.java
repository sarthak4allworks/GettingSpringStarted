package agarwal.sarthak.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import agarwal.sarthak.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpo implements EmployeeDAO 
{
	// define field for entity manager
	private EntityManager entitymanager;
	
	// setup constructor injection
	@Autowired
	public EmployeeDAOHibernateImpo(EntityManager theEntityManager)
	{
		this.entitymanager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll()
	{		
		// get the current hibernate session
		Session currentSession = entitymanager.unwrap(Session.class);
		
		// create the query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		// execute the query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		// return the result
		return employees;
	}

	@Override
	public Employee findById(int theId) 
	{
		Session currentSession = entitymanager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, theId);
		return employee;
	}

	@Override
	public void save(Employee theEmployee) 
	{
		Session currentSession = entitymanager.unwrap(Session.class);
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) 
	{
		Session currentSession = entitymanager.unwrap(Session.class);
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}
