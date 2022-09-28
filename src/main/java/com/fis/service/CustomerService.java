package com.fis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fis.entity.Customer;
import com.fis.exceptions.CustomerException;
import com.fis.repository.CustomerRepository;

@Component
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Customer getCustomer(long accNo) {

		Customer customer = customerRepository.findByAccountNo(accNo);
		if (customer == null) {
			throw new CustomerException("No customer with accountNo : " + accNo);
		}
		return customer;
	}

	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public float getBalance(long accId) {

		Customer customer = customerRepository.findByAccountNo(accId);
		return customer.getBalance();
	}

	public float deposit(long accId, float amount) {

		Customer customerFromDb = getCustomer(accId);
		customerFromDb.setBalance(customerFromDb.getBalance() + amount);
		customerRepository.save(customerFromDb);

		return customerFromDb.getBalance();
	}

	public float widthdraw(long accId, float amount) {

		Customer customerFromDb = getCustomer(accId);
		customerFromDb.setBalance(customerFromDb.getBalance() - amount);
		customerRepository.save(customerFromDb);

		return customerFromDb.getBalance();
	}

	public List<Customer> getAll() {

		return customerRepository.findAll();
	}

}
