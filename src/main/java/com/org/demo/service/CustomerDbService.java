package com.org.demo.service;

import com.org.demo.model.Customer;

public interface CustomerDbService {
	
	public Customer registerCustomer(Customer customer);
	
	public Customer findByemailIdAndPassword(String emailId, String password);
}
