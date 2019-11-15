package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.RabbitMqConsumerService;

@RestController
@RequestMapping("/java-rabbitmq")
public class CustomerController {

	@Autowired
	private RabbitMqConsumerService rabbitMqConsumerService;

	@GetMapping("/getList")
	public Iterable<Customer> listCustomers() {
		Iterable<Customer> customers = rabbitMqConsumerService.getSavedValues();
		return customers;

	}

}
