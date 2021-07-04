package agarwal.sarthak.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import agarwal.sarthak.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController 
{
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData()
	{
		Employee emp1 = new Employee(1, "Sarthak", "Agarwal", "agarwalsarthak@gmail.com");
		Employee emp2 = new Employee(2, "Sushmita", "Gupta", "guptasushmita@gmail.com");
		Employee emp3 = new Employee(3, "Swati", "Sreeram", "sreeramswati@gmail.com");
		theEmployees = new ArrayList<Employee>();
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
	}
	
	@GetMapping("/list")
	public String sayHello(Model theModel)
	{
		theModel.addAttribute("employees", theEmployees);
		return "list-employees";
	}
}
