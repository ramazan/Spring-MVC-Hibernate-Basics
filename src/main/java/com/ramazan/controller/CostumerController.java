package com.ramazan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramazan.dao.CustomerDAO;
import com.ramazan.entity.Customer;
import com.ramazan.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CostumerController {

	@Autowired
	// private CustomerDAO customerDAO;
	private CustomerService customerService;

	@GetMapping("/list")
	public String getCustomer(Model theModel) {

		List<Customer> theCustomers = customerService.getCustomers();

		theModel.addAttribute("customers", theCustomers);

		return "lists-customers";
	}

	@GetMapping("/add-customer")
	public String showFormAdd(Model theModel) {

		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saeveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormUpdate")
	public String updateCustomerForm(@RequestParam("customerId") int customerId, Model theModel) {

		Customer updateCustomer = customerService.getCustomer(customerId);

		theModel.addAttribute("customer", updateCustomer);

		return "customer-form";
	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int customerId,Model theModel) {
		
		customerService.deleteCustomer(customerId);
		
		return "redirect:/customer/list";

	}

}
