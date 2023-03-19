package com.org.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.org.demo.model.Customer;
import com.org.demo.service.CustomerDbService;

@Controller
public class LoginRegistrationController {
	
	@Autowired
	private CustomerDbService customerDbService;
	
	
	@GetMapping("/")
	public String getIndexPage(ModelMap map) {
		map.addAttribute("customer", new Customer());

		return "index";
	}
	
	
	@PostMapping("/register")
	public String registrationForm(@ModelAttribute("customer") Customer customer) {
		customerDbService.registerCustomer(customer);
		return "registersuccess";
	}

	@GetMapping("/register")
	public String getRegistrationPage(ModelMap map) {
		map.addAttribute("customer", new Customer());

		return "registrationpage";
	}
	@GetMapping("/login")
	public String getLoginPage(ModelMap map) {
		map.addAttribute("customer", new Customer());
		
		return "loginpage";
	}  
	@PostMapping("/login")
	public String loginForm(@ModelAttribute("customer") Customer customer) {
		Customer authUser=customerDbService.findByemailIdAndPassword(customer.getEmailId(),customer.getPassword());
		System.out.print(authUser);
		if(Objects.nonNull(authUser)) {
			return "loginsuccess";
		}
		return "loginpage";
	}
}