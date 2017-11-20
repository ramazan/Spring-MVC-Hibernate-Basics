package com.ramazan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ramazan.dao.CustomerDAO;
import com.ramazan.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	public Customer getCustomer(int customerId) {
		return customerDAO.getCustomer(customerId);
	}

	@Override
	public void deleteCustomer(int customerId) {
		customerDAO.deleteCustomer(customerId);
	}

	
}
