package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.RabbitMqSender;

@RestController
public class RabbitMqController {

	@Autowired
	private RabbitMqSender rabbitMqSender;
	
	@PostMapping("/java-rabbitmq/producer")
	public String producer(@ModelAttribute("customer") Customer theCustomer) {
		rabbitMqSender.send(theCustomer);
		return "Message sent to the RabbitMQ  Successfully";
	}
}
