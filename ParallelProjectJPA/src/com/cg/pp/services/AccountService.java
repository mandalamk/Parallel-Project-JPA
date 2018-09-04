package com.cg.pp.services;

import java.util.ArrayList;

public interface AccountService {

/*	int showBalance(int accNum) throws AccountException;
	int deposit(int accNum, int amount) throws AccountException;
	int withdraw(int accNum, int amount) throws AccountException;
	ArrayList<Integer> transfer(int accNum_from,int accNum_to, int amount) throws AccountException;
	void printTransactions(int accNum) throws AccountException;*/
	
	
	int deposit(String phone, int amount);
	ArrayList<Integer> transfer(String phFrom, String phTo, int amount);
	int withdraw(String phone, int amount);
	int showBalance(String phone);
	void printTransactions(String phone);
}
