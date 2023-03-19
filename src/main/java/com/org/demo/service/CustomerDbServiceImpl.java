package com.org.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.demo.dao.CustomerDbDao;
import com.org.demo.model.Customer;

@Service("customerDbService")
public class CustomerDbServiceImpl implements CustomerDbService{

	@Autowired
	private CustomerDbDao customerDbDao;

	@Override
	public Customer registerCustomer(Customer customer) {
		
		customerDbDao.save(customer);
		return customer;
	}

	@Override
	public Customer findByemailIdAndPassword(String emailId, String password) {
		Customer customer = customerDbDao.findByemailIdAndPassword(emailId, password);
		return customer;
	}

}
