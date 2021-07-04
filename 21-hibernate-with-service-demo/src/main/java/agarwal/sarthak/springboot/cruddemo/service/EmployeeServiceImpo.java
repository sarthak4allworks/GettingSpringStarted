package agarwal.sarthak.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agarwal.sarthak.springboot.cruddemo.dao.EmployeeDAO;
import agarwal.sarthak.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpo implements EmployeeService 
{
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpo(EmployeeDAO theEmployeeDAO)
	{
		this.employeeDAO = theEmployeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() 
	{
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) 
	{
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) 
	{
		employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) 
	{
		employeeDAO.deleteById(theId);
	}

}
