package com.fis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fis.entity.Customer;
import com.fis.entity.Transaction;
import com.fis.entity.TransactionDto;
import com.fis.repository.TransactionRepository;

@Component
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	CustomerService customerService;

	public TransactionDto fundTransfer(TransactionDto transactionDto) {

		Transaction transaction = new Transaction();

		Customer depositor = customerService.getCustomer(transactionDto.getDepositorAccNo());
		depositor.setBalance(depositor.getBalance() - transactionDto.getAmount());
		transaction.setDepositor(depositor);

		Customer receiver = customerService.getCustomer(transactionDto.getReceiverAccNo());
		receiver.setBalance(receiver.getBalance() + transactionDto.getAmount());
		transaction.setReceiver(receiver);

		transactionDto.setStatus("SUCCESS");

		transaction.setAmount(transactionDto.getAmount());
		transaction.setTimeStamp(transactionDto.getTimeStamp());
		transaction.setStatus(transactionDto.getStatus());

		transactionRepository.save(transaction);

		return transactionDto;

	}

	public List<TransactionDto> getAll() {

		List<TransactionDto> transactionDtos = transactionRepository.findAll().stream().map((transaction) -> {
			TransactionDto transactionDto = new TransactionDto();
			transactionDto.setDepositorAccNo(transaction.getDepositor().getAccountNo());
			transactionDto.setReceiverAccNo(transaction.getReceiver().getAccountNo());
			transactionDto.setAmount(transaction.getAmount());
			transactionDto.setTimeStamp(transaction.getTimeStamp());
			transactionDto.setStatus(transaction.getStatus());

			return transactionDto;
		}).toList();
		return transactionDtos;
	}
}
