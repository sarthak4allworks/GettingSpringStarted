package agarwal.sarthak.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import agarwal.sarthak.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
