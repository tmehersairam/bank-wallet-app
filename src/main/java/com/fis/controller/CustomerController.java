package com.fis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fis.entity.Customer;
import com.fis.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	
	@GetMapping("/accounts")
	public ResponseEntity<List<Customer>> getAll() {

		return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
	}
	@GetMapping("/account/{accId}")
	public ResponseEntity<Customer> getAccount(@PathVariable(value = "accId") long accId) {

		return new ResponseEntity<>(customerService.getCustomer(accId), HttpStatus.OK);
	}
	
	@PostMapping("/account")
	public ResponseEntity<Customer> createAccount(@RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
	}

	@GetMapping("/account/{accId}/balance")
	public ResponseEntity<String> getBalance(@PathVariable(value = "accId") long accId) {

		return new ResponseEntity<>("Balance is " + customerService.getBalance(accId), HttpStatus.OK);
	}

	@PostMapping("/account/{accId}/deposit/{amount}")
	public ResponseEntity<String> deposit(@PathVariable(value = "accId") long accId,
			@PathVariable(value = "amount") float amount) {
		return new ResponseEntity<>("Update balance is " + customerService.deposit(accId, amount), HttpStatus.CREATED);
	}

	@PostMapping("/account/{accId}/withdraw/{amount}")
	public ResponseEntity<String> withdraw(@PathVariable(value = "accId") long accId,
			@PathVariable(value = "amount") float amount) {
		return new ResponseEntity<>("Update balance is " + customerService.widthdraw(accId, amount),
				HttpStatus.CREATED);
	}

}
