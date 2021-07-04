package agarwal.sarthak.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import agarwal.sarthak.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpo implements EmployeeDAO 
{
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpo(EntityManager theEntityManager)
	{
		this.entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() 
	{
		Query theQuery = entityManager.createQuery("from Employee");
		@SuppressWarnings("unchecked")
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theId) 
	{
		Employee theEmployee = entityManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) 
	{
		Employee dbEmployee = entityManager.merge(theEmployee);
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) 
	{
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}
