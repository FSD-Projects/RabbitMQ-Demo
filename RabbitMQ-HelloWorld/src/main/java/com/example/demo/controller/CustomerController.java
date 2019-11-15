package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Customer;

@Controller
public class CustomerController {
	@GetMapping("/")
	public String getForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}
}
