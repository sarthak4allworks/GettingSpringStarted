package agarwal.sarthak.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import agarwal.sarthak.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//	Add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
