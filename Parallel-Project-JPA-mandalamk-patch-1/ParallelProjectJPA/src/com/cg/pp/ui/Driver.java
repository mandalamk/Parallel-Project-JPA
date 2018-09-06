/*
 CHECK FOR THE RUN OF THE WHILE LOOP FOR INPUTMISMATCHEXCEPTION.
 TAKES THE WRONG INPUT TO AN ACTION AS THE INPUT TO YES/NO QUESTION FOR MORE TRANSACTION.
 BECAUSE OF THIS THE LOOP RUNS ONE TIME MORE EACH TIME.
 
 */
package com.cg.pp.ui;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.InputMismatchException;
import com.cg.pp.exceptions.AccountException;
import com.cg.pp.services.AccountServiceImpl;

public class Driver {
 
	public static void main(String[] args) throws AccountException{

		AccountServiceImpl impl = new AccountServiceImpl();
		System.out.println("Welcome!");
		Scanner sc = new Scanner(System.in);
		boolean bool=true;
		int i=1;
		System.out.println(" 1.Create new account \n 2.Transfer funds \n 3.Deposit money \n 4.Withdraw funds \n 5.Show balance \n 6.Show Transactions \n 7.Exit");
		System.out.println("Enter Choice.");
		
		while(bool == true) {
			
			String response="";
			if(i!=1) {
				System.out.println("Do you want to do any other Transaction? \n 1.Yes/Y \n 2.No/N");
				response = sc.next();
			}
			if(response.toLowerCase().equals("yes") || response.toLowerCase().equals("y")||i==1)
			{
				if(i!=1) {
				System.out.println(" 1.Create new account \n 2.Transfer funds \n 3.Deposit money \n 4.Withdraw funds \n 5.Show balance \n 6.Show Transactions \n 7.Exit");
				System.out.println("Enter Choice.");
				}
				int n = sc.nextInt();

				switch (n) {
				case (1): {
					System.out.println("Enter Customer Name:");
					String name = sc.next();
					System.out.println("Enter Phone number:");
					String phone = sc.next();
					try {
						impl.createAccount(name,phone);
					} catch (AccountException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					
					break;
				}
								
				case (2): {
					String phFrom="";
					String phTo = "";
					int amount = 0;
					System.out.println("sender's phone:");
					phFrom = sc.next();
					if (!(Pattern.matches("[0-9]{10}", phFrom))) {
						throw new AccountException("Account Number Invalid! Enter 10 digits.");
					}
					System.out.println("receiver's phone:");
					phTo = sc.next();
					if (!(Pattern.matches("[0-9]{10}", phTo))) {
						throw new AccountException("Account Number Invalid! Enter 10 digits.");
					}
					try {
						System.out.println("amount:");
						amount = sc.nextInt();
					} catch (InputMismatchException e1) {
						// TODO Auto-generated catch block
						System.out.println("Enter Only Numbers.");
					}
					try {
						impl.transfer(phFrom, phTo, amount);
					} catch (AccountException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					
					break;
				}
				
				case (3): {
					int amt = 0;
					System.out.println("enter phone");
					String phone = sc.next();
					if (!(Pattern.matches("[0-9]{10}", phone))) {
						throw new AccountException("Account Number Invalid! Enter 10 digits.");
					}
					try {
						System.out.println("enter amount:");
						amt = sc.nextInt();
					} catch (InputMismatchException e1) {
						// TODO Auto-generated catch block
						System.out.println("Enter Only Numbers.");
					}
					try {
						impl.deposit(phone, amt);
					} catch (AccountException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					
					break;
				}
				
				case (4): {
					int amt = 0;
					System.out.println("enter phone");
					String phone = sc.next();
					if (!(Pattern.matches("[0-9]{10}", phone))) {
						throw new AccountException("Account Number Invalid! Enter 10 digits.");
					}
					try {
						System.out.println("enter amount:");
						amt = sc.nextInt();
					} catch (InputMismatchException e1) {
						// TODO Auto-generated catch block
						System.out.println("Enter Only Numbers.");
					}
					try {
						 impl.withdraw(phone, amt);
					} catch (AccountException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				   
					break;
				}
					
				case (5): {
					int bal=0;
					System.out.println("enter phone");
					String phone = sc.next();
					if (!(Pattern.matches("[0-9]{10}", phone))) {
						throw new AccountException("Account Number Invalid! Enter 10 digits.");
					}
					try {
						bal=impl.showBalance(phone);
					} catch (AccountException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					
					System.out.println(bal);
					break;
				}
				
				
				case(6):{
					System.out.println("enter phone");
					String phone = sc.next();
					if (!(Pattern.matches("[0-9]{10}", phone))) {
						throw new AccountException("Account Number Invalid! Enter 10 digits.");
					}
					try {
						impl.printTransactions(phone);
					} catch (AccountException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					
					break;
				}
				case(7):
					System.out.println("Thank you for using the service.");
					sc.close();
					bool = false;
					break;
				}

			}
			else if(response.toLowerCase().equals("no") || response.toLowerCase().equals("n")){
				System.out.println("Thank You for using the application.");
				bool=false;
				break;
			}
			else {
				System.out.println(response);
				System.out.println("Please enter Valid Response.");
			}
			i++;
		}
	}
}