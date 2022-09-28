package com.fis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
