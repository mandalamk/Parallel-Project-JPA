package com.cg.pp.dao;

import java.util.ArrayList;

import com.cg.pp.entities.Account;
import com.cg.pp.entities.Transaction;

public interface AccountDao {

	Account createAccount(String name, String phone);
	ArrayList<Integer> transfer(String phFrom, String phTo, int amount);
	int deposit(String phone, int amount);
	int withdraw(String phone, int amount);
	int showBalance(String phone);
	ArrayList<Transaction> printTransactions(String phone);

}
