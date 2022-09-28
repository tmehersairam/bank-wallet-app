package com.fis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByAccountNo(long accNo);
}


