package com.dyanamicpoly;

//import java.time.LocalDate;
//import java.time.LocalTime;
import java.util.Scanner;

public  class Savings extends BankAccount {
	Scanner sc=new Scanner(System.in);

	static double minBalanceRequired = 1000;
	static double Rate=0.03;
	
////////////////////////////-------->>Constructors<<---------////////////////////////////////

	
	public Savings() {
		super();
		
	}

	public Savings(long accountNumber, String accountHolderName, double balance, String isActive) {
		super( accountNumber,  accountHolderName,  balance,  isActive);
		
	}
	
	
////////////////////////////-------->>setters-getters<<---------////////////////////////////////

	public static double getMinBalanceRequired() {
		return minBalanceRequired;
	}

	public static void setMinBalanceRequired(double minBalanceRequired) {
		Savings.minBalanceRequired = minBalanceRequired;
	}	
	

////////////////////////////-------->>Display<<---------////////////////////////////////
	
	public void display() {
		System.out.println("\n****Savings account details*****");
		super.display();
//		System.out.println("\nMininmum Balance required: " + Savings.minBalanceRequired);
	}


////////////////////////////-------->>ROI<<---------////////////////////////////////

	@Override
	public void CalculateROI() {
		
		System.out.println("Rate of Interest of Savings Account:" + Savings.Rate);
		return ;
	}

////////////////////////////-------->>Cash withdrawl<<---------////////////////////////////////

	@Override
	public void cashWithdraw(double useramount) {
		
		
		try {
			if(useramount>this.balance) {

				throw new InsufficientBalanceException("Insufficient Balance ,Can't wihtdraw");
			}
			
			else {
				this.balance-=useramount;
				//--creating an object of transaction details class to connect it here--//
				TransactionDetails object=new TransactionDetails(useramount,"withdraw");

				System.out.println("Amount withdrawl Successfully...");
				 
				transactionArray[transactionCount++]=object;
				
				
			}
		}catch(InsufficientBalanceException e) {
			System.err.println("Error Occured: " + e.getMessage());
		
		}
		
	}
	/*

////////////////////////////----------->>Fund Transfer<<-------------////////////////////////

	public  void fundTransfer(double amount) {
		
		try {
			
			if(amount>this.balance) {

				throw new InsufficientBalanceException("Insufficient Balance ,Can't transfer funds");
			}
			
			else {
				 this.balance -= amount;
				 TransactionDetails object=new TransactionDetails(amount,"fund transfer");

				System.out.println("Amount TRansfered Successfully...");
				
				transactionArray[transactionCount++]=object;
				
				
			}
		}catch(InsufficientBalanceException e) {
			System.err.println("Error Occured: " + e.getMessage());
		
		}
		
		
		
	}
*/
	
	
}
