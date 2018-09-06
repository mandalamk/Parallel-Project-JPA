package com.cg.pp.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.pp.entities.Account;
import com.cg.pp.entities.Transaction;

public class JPAAccountDAO implements AccountDao{
	
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("mine");
	EntityManager em = emf.createEntityManager();

	@Override
	public Account createAccount(String name, String phone) {
		
		Account a = new Account(1000, phone, name, (int)Math.random()*10000);

		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		System.out.println("Account created for "+a.getCustName());
		return a;
	}

	@Override
	public int showBalance(String phone) {
		
		Account acc;
		em.getTransaction().begin();
		acc = em.find(Account.class, phone);
		em.getTransaction().commit();
		return acc.getBalance();
	}

	@Override
	public int deposit(String phone, int amount) {
		// TODO Auto-generated method stub
		
		Account acc;
		em.getTransaction().begin();
		acc = em.find(Account.class, phone);
		int newBal;
		newBal = acc.getBalance()+amount;
		acc.setBalance(newBal);
		em.merge(acc);
		em.flush();
		
		em.persist(new Transaction(acc.getPhone(),acc.getPhone(), ("SELF DEPOSIT "
				 + amount +". Final Balance : " +acc.getBalance())));
		em.getTransaction().commit();		
		return newBal;
	}

	@Override
	public int withdraw(String phone, int amount) {
		
		Account acc;
		em.getTransaction().begin();
		acc = em.find(Account.class, phone);
		int newBal;
		newBal = acc.getBalance()-amount;
		acc.setBalance(newBal);
		em.merge(acc);
		em.flush();
		
		em.persist(new Transaction(acc.getPhone(), acc.getPhone(), ("SELF WITHDRAW "
				 + amount +". Final Balance : " +acc.getBalance())));
		em.getTransaction().commit();		
		return newBal;
	}

	@Override
	public ArrayList<Integer> transfer(String phFrom, String phTo, int amount ) {
		
		ArrayList<Integer> al = new ArrayList<>();
		
		em.getTransaction().begin();
		Account aFrom = em.find(Account.class, phFrom);
		Account aTo = em.find(Account.class, phTo);
		
		aFrom.setBalance(aFrom.getBalance()-amount);
		al.add(aFrom.getBalance());
		aTo.setBalance(aTo.getBalance()+amount);
		al.add(aTo.getBalance());
		em.merge(aFrom);
		em.merge(aTo);
		em.flush();

		em.persist(new Transaction(aFrom.getPhone(), aTo.getPhone(), ("DEPOSITED "
				 + amount +" BY " +aFrom.getCustName()+" IN "+aTo.getCustName()+"'s account.")));
		em.getTransaction().commit();
		return al;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Transaction> printTransactions(String phone) {
	
		String sql="select tran from  Transaction tran where tran.phoneFrom ="+phone+" or tran.phoneTo="+phone;
		Query query=em.createQuery(sql);
		ArrayList<Transaction> list=(ArrayList<Transaction>) query.getResultList();
		return list;
	}
	
}
