package com.dyanamicpoly;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrentAccount extends BankAccount {
	Scanner sc=new Scanner(System.in);
	
	
	final double overdraftLimit=5000;			//const is final in java now//		
	static double rateofinterest=0.03;
	
	
////////////////////////////-------->>Constructors<<---------////////////////////////////////

	public CurrentAccount() {
		
	}
	
	public CurrentAccount(long accountNumber, String accountHolderName, double balance, String isActive) {
		super( accountNumber,  accountHolderName,  balance,  isActive);
		
	}

////////////////////////////-------->>setters-getters<<---------////////////////////////////////

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

//	public void setOverdraftLimit(double overdraftLimit) {
//		this.overdraftLimit = overdraftLimit;
//	}
	
////////////////////////////-------->>Display<<---------////////////////////////////////
	
	public void display() {
		
		System.out.println("****Current Account details****\n");
		System.out.println("\nOverDraft Limit: " + this.overdraftLimit);
		super.display();
	}

	
	
	
////////////////////////////-------->>Rate Of interest<<---------////////////////////////////////

	@Override
	public void CalculateROI() {
		 System.out.println("rate of interest of Current account:" + CurrentAccount.rateofinterest) ;
				
		return ;
	}
	

////////////////////////////-------->>Cash withdrawl<<---------////////////////////////////////

	@Override
	public  void cashWithdraw(double amount) {

		//--creating an object of transaction details class to connect it here--//
				
		
		double can_withdraw=this.overdraftLimit+this.balance;//this variable will work for calculation fo overdraft concept//
		try {
			if(amount<=this.balance) {
				this.balance-=amount;
				
				TransactionDetails object=new TransactionDetails(amount,"withdraw");				
				transactionArray[transactionCount++]=object;	
				return;
				
			}

			//amount>balance
			
			System.out.println("Insufficient Balance!!");
			
			try {
				System.out.println("You are Transfering fund amount from your overDraft.. Continue??");
				System.out.println("1.Yes   2.No");
			} catch (InputMismatchException e) {
				// TODO: handle exception
				System.err.println("please enter valid input");
			}
			int userc=sc.nextInt();
			switch(userc) {
			
				case 1:{
					
					System.out.println("Withdrawing amount from your overDraft..");
					if(amount>=balance && amount<=can_withdraw) {
						
						this.balance-=amount;
						can_withdraw=can_withdraw-balance;
						
						TransactionDetails object=new TransactionDetails(amount,"withdraw");				

						System.out.println("Available amount you  can_withdraw here after : "+ can_withdraw);
						transactionArray[transactionCount++]=object;	

					}
					else if(amount > can_withdraw){
						throw new InsufficientBalanceException("Insufficeint Balance, you are withdrawing beyond overDraft limit");
						
					}
					break;
				}
				case 2:{
					System.out.println("Canceling...");
					break;
				}
				default:{
					System.out.println("Enter valid choice!");
					break;
				}
			}
			
		
		}catch(InsufficientBalanceException e) {
			System.err.println("Error occured: " + e.getMessage());
		}
		
		
	}
		
	

////////////////////////////----------->>Fund Transfer<<-------------////////////////////////

public  void fundTransfer(double amount) {


	//--creating an object of transaction details class to connect it here--//
	TransactionDetails object=new TransactionDetails();
			
	
	double can_withdraw=this.overdraftLimit+this.balance;//this variable will work for calculation fo overdraft concept//
	try {
		if(amount<=this.balance) {
			this.balance-=amount;
			
			object.setTransactionAmount(amount);
			object.setTransactionId(object.getTransactionId());
			object.setTransactionDate(LocalDate.now());
			object.setTransactionTime(LocalTime.now());
			object.setTransactionType("Fund Transfer");
			object.setTransactionId(object.generateTransactionId());

			
			transactionArray[transactionCount++]=object;
//			No_of_Transactions_per_Day++;	//keep tract of number of transactions//

	        display();
			
			
		}

		else {		//amount>balance
			
			System.out.println("Insufficient Balance!!");
			
			System.out.println("You are Transfering fund amount from your overDraft.. Continue??");
			System.out.println("1.Yes   2.No");
			int userc=sc.nextInt();
			switch(userc) {
			
				case 1:{
					
					System.out.println("Transfering amount from your overDraft..");
					if(amount>=balance && amount<=can_withdraw) {
						
						this.balance-=amount;
						can_withdraw=can_withdraw-balance;
						
						object.setTransactionAmount(amount);
						System.out.println("Amount Transfered Successfully...");
						object.setTransactionAmount(amount);
						object.setTransactionId(object.getTransactionId());
						object.setTransactionDate(LocalDate.now());
						object.setTransactionTime(LocalTime.now());
						object.setTransactionType("Funds Transfer");
						object.setTransactionId(object.generateTransactionId());
						System.out.println("Available amount you  can_withdraw here after : "+ can_withdraw);
						this.display();
						
					}
					else if(amount > can_withdraw){
						throw new InsufficientBalanceException("Insufficeint Balance, you are withdrawing beyond overDraft limit");
						
					}
					break;
				}
				case 2:{
					System.out.println("Canceling...");
					break;
				}
				default:{
					System.out.println("Enter valid choice!");
					break;
				}
			}
			
		}
	}catch(InsufficientBalanceException e) {
		System.err.println("Error occured: " + e.getMessage());
	}
	
	
}


}




