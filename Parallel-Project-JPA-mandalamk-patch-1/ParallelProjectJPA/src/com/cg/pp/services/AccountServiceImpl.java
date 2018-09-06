/*
CHECK FOR SUFFICIENT FUNDS DURING TRANSFER. DISPLAY APPROPRIATE EXCEPTIONS.
 
*/

package com.cg.pp.services;

import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.pp.dao.JPAAccountDAO;
import com.cg.pp.entities.Account;
import com.cg.pp.entities.Transaction;
import com.cg.pp.exceptions.AccountException;

public class AccountServiceImpl implements AccountService {

	JPAAccountDAO jpac = new JPAAccountDAO();
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mine");
	EntityManager em = emf.createEntityManager();
	
	private void check(int amount) throws AccountException {
		if (amount < 0)
			throw new AccountException("This transaction is Not Possible.");
	}
	
	private void validate(String phone) throws AccountException {
		
		Account acc;
		em.getTransaction().begin();
		acc = em.find(Account.class, phone);
		em.getTransaction().commit();
		if (acc == null)
			throw new AccountException("Account Number Invalid!");
	}

	public Account createAccount(String name, String phone) throws AccountException {
		Account acc;
		em.getTransaction().begin();
		acc = em.find(Account.class, phone);
		em.getTransaction().commit();
		if (!(acc == null))
			throw new AccountException("Account already exists!");
		return jpac.createAccount(name,phone);
	}
	
	@Override
	public int showBalance(String phone) throws AccountException {
		validate(phone);
		return jpac.showBalance(phone);
	}

	@Override
	public int deposit(String phone, int amount) throws AccountException {
		validate(phone);
		check(amount);
		return jpac.deposit(phone, amount);
	}

	@Override
	public int withdraw(String phone, int amount) throws AccountException {
		validate(phone);
		check(amount);
		if ((jpac.showBalance(phone) - amount) <= 0) {
			throw new AccountException("Insufficient funds. Cannot perform the Transaction.");
		}
		return jpac.withdraw(phone, amount);
	}

	@Override
	public void printTransactions(String phone) throws AccountException {

		validate(phone);
		ArrayList<Transaction> al = new ArrayList<>();
		
		al.addAll(jpac.printTransactions(phone));
		
		for (Iterator<Transaction> iterator = al.iterator(); iterator.hasNext();) {
			Transaction t = (Transaction) iterator.next();
			System.out.println(t.getTransactionId()+" "+t.getAction());	
		}
		
	}

	@Override
	public ArrayList<Integer> transfer(String phFrom, String phTo, int amount) throws AccountException {
		validate(phFrom);
		validate(phTo);
		check(amount);
		if ((jpac.showBalance(phFrom) - amount) <= 0) {
			throw new AccountException("Insufficient funds. Cannot perform the Transaction.");
		}
		return jpac.transfer(phFrom, phTo, amount);
	}

}