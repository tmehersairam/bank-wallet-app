package com.fis.entity;

import java.util.Calendar;
import java.util.Date;

public class TransactionDto {

	private long depositorAccNo;
	private float amount;
	private long receiverAccNo;
	private Date timeStamp = Calendar.getInstance().getTime();
	private String status;

	public TransactionDto() {
		super();
	}

	public TransactionDto(long depositorAccNo, float amount, long receiverAccNo, String status) {
		super();
		this.depositorAccNo = depositorAccNo;
		this.amount = amount;
		this.receiverAccNo = receiverAccNo;

		this.status = status;
	}

	public long getDepositorAccNo() {
		return depositorAccNo;
	}

	public void setDepositorAccNo(long depositorAccNo) {
		this.depositorAccNo = depositorAccNo;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public long getReceiverAccNo() {
		return receiverAccNo;
	}

	public void setReceiverAccNo(long receiverAccNo) {
		this.receiverAccNo = receiverAccNo;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = Calendar.getInstance().getTime();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
