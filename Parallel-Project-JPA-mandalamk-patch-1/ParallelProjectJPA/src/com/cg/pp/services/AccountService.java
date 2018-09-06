package com.cg.pp.services;

import java.util.ArrayList;

import com.cg.pp.exceptions.AccountException;

public interface AccountService {

	int deposit(String phone, int amount) throws AccountException;
	ArrayList<Integer> transfer(String phFrom, String phTo, int amount) throws AccountException;
	int withdraw(String phone, int amount) throws AccountException;
	int showBalance(String phone) throws AccountException;
	void printTransactions(String phone) throws AccountException;
}
