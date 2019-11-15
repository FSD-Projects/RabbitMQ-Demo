package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class RabbitMqConsumerService {
	private static final String queue = "foo.queue";
	@Autowired
	private CustomerRepository customerRepository;

	@RabbitListener(queues = queue)
	@Transactional
	public void receiveMessage(Customer customer) {
		customerRepository.save(customer);
		System.out.println("Received Message from foo-queue >>" + customer);
	}

	public Iterable<Customer> getSavedValues() {
		Iterable<Customer> customers = customerRepository.findAll();
		return customers;
	}
}
