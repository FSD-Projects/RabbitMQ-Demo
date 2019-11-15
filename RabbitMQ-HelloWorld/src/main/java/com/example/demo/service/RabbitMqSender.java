package com.example.demo.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;

@Service
public class RabbitMqSender {
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${foo.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${foo.rabbitmq.routingkey}")
	private String routingkey;	
	
	public String send(Customer customer) {
		amqpTemplate.convertAndSend(exchange, routingkey, customer);
		System.out.println("Send msg = " + customer);
		return "Message consumed by the RabbitMQ  Successfully";
	    
	}
}
