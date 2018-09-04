/*
CHECK FOR SUFFICIENT FUNDS DURING TRANSFER. DISPLAY APPROPRIATE EXCEPTIONS.
 
*/

package com.cg.pp.services;

import java.util.ArrayList;
import java.util.Iterator;

import com.cg.pp.dao.JPAAccountDAO;
import com.cg.pp.entities.Account;
import com.cg.pp.entities.Transaction;

public class AccountServiceImpl implements AccountService {

	JPAAccountDAO jpac = new JPAAccountDAO();

	public AccountServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public Account createAccount(String name, String phone)
	{
		return jpac.createAccount(name,phone);
	}
	
	@Override
	public int showBalance(String phone) {
		// TODO Auto-generated method stub
		return jpac.showBalance(phone);
	}

	@Override
	public int deposit(String phone, int amount) {
		// TODO Auto-generated method stub
		return jpac.deposit(phone, amount);
	}

	@Override
	public int withdraw(String phone, int amount) {
		// TODO Auto-generated method stub
		return jpac.withdraw(phone, amount);
	}

	@Override
	public void printTransactions(String phone) {
		// TODO Auto-generated method stub
		ArrayList<Transaction> al = new ArrayList<>();
		
		al.addAll(jpac.printTransactions(phone));
		
		for (Iterator<Transaction> iterator = al.iterator(); iterator.hasNext();) {
			Transaction transaction = (Transaction) iterator.next();
			System.out.println(transaction.getAction());
			
		}
		
	}

	@Override
	public ArrayList<Integer> transfer(String phFrom, String phTo, int amount) {
		// TODO Auto-generated method stub
		return jpac.transfer(phFrom, phTo, amount);
	}



}
