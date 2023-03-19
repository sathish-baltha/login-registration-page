package com.org.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.demo.model.Customer;

@Repository("customerDbDao")
public interface CustomerDbDao extends JpaRepository<Customer, Integer> {

	public Customer findByemailIdAndPassword(String emailId, String password);
}
