/*
 CHECK FOR THE RUN OF THE WHILE LOOP FOR INPUTMISMATCHEXCEPTION.
 TAKES THE WRONG INPUT TO AN ACTION AS THE INPUT TO YES/NO QUESTION FOR MORE TRANSACTION.
 BECAUSE OF THIS THE LOOP RUNS ONE TIME MORE EACH TIME.
 
 */
package com.cg.pp.ui;

import java.util.Scanner;

import com.cg.pp.services.AccountServiceImpl;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		AccountServiceImpl impl = new AccountServiceImpl();
		System.out.println("Welcome!");
		Scanner sc = new Scanner(System.in);
		boolean bool=true;
		int i=1;
		System.out.println(" 1.Create new account \n 2.Transfer funds \n 3.Deposit money \n 4.Withdraw funds \n 5.Show balance \n 6.Show Transactions \n 7.Exit");
		System.out.println("Enter Choice.");
		
		while(bool == true)
		{
			
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
					impl.createAccount(name,phone);
					
					break;
				}
				
				
				case (2): {
					String phFrom="";
					String phTo = "";
					int amount;
					
					System.out.println("sender's phone:");
					phFrom = sc.next();
					System.out.println("receiver's phone:");
					phTo = sc.next();
					System.out.println("amount:");
					amount = sc.nextInt();
						
					impl.transfer(phFrom, phTo, amount);
					break;
				}
				
				case (3): {
					System.out.println("enter phone");
						String phone = sc.next();
					System.out.println("enter amount:");
					int amt = sc.nextInt();
					
					impl.deposit(phone, amt);
					break;

				}
				
				case (4): {
					
					System.out.println("enter phone");
					String phone = sc.next();
				System.out.println("enter amount:");
				int amt = sc.nextInt();
				
				impl.withdraw(phone, amt);
					break;
				}
				
				
				case (5): {
					System.out.println("enter phone");
					String phone = sc.next();
					
					impl.showBalance(phone);
					break;
				}
				
				
				case(6):{
					System.out.println("enter phone");
					String phone = sc.next();
					
					impl.printTransactions(phone);

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
