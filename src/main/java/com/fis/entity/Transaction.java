package com.fis.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tId;

	@OneToOne
	private Customer depositor;
	private float amount;
	@OneToOne
	private Customer receiver;
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;
	private String status;

	public Transaction() {
		super();
	}

	public Transaction(int tId, Customer depositor, float amount, Customer receiver, String status) {
		super();
		this.tId = tId;
		this.depositor = depositor;
		this.amount = amount;
		this.receiver = receiver;
	
		this.status = status;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public Customer getDepositor() {
		return depositor;
	}

	public void setDepositor(Customer depositor) {
		this.depositor = depositor;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Customer getReceiver() {
		return receiver;
	}

	public void setReceiver(Customer receiver) {
		this.receiver = receiver;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
