package com.cg.pp.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	private String phoneFrom;
	private String phoneTo;
	private String action;
	private Date date;

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(String phoneFrom, String phoneTo, String action) {
		super();
		this.phoneFrom = phoneFrom;
		this.phoneTo = phoneTo;
		this.action = action;
	}



	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public String getPhoneFrom() {
		return phoneFrom;
	}

	public void setPhoneFrom(String phoneFrom) {
		this.phoneFrom = phoneFrom;
	}

	public String getPhoneTo() {
		return phoneTo;
	}

	public void setPhoneTo(String phoneTo) {
		this.phoneTo = phoneTo;
	}

}
