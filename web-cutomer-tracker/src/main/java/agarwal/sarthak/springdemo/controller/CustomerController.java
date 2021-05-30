package agarwal.sarthak.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import agarwal.sarthak.springdemo.Service.CustomerService;
import agarwal.sarthak.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController 
{
	// need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
//	@RequestMapping("/list")
	@GetMapping("/list")  // only to handle get mapping
	public String listCustomer(Model theModel)
	{
		// get customers from service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
		// save the customer using the service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
}
