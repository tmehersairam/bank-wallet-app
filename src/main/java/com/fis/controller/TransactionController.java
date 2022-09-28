package com.fis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fis.entity.TransactionDto;
import com.fis.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@PostMapping("/transaction")
	public ResponseEntity<TransactionDto> transerFund(@RequestBody TransactionDto transactionDto) {

		return new ResponseEntity<>(transactionService.fundTransfer(transactionDto), HttpStatus.CREATED);
	}

	@GetMapping("/transaction")
	public ResponseEntity<List<TransactionDto>> getAll() {

		return new ResponseEntity<>(transactionService.getAll(), HttpStatus.OK);
	}

}
