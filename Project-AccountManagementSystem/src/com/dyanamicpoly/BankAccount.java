package com.dyanamicpoly;
import java.time.LocalDate;
import java.time.LocalTime;
//import java.util.Date;
import java.util.Scanner;

public abstract class BankAccount {
	Scanner sc=new Scanner(System.in);

	
	long accountNumber; 
	String accountHolderName;
	double balance;
	String isActive;		
	LocalDate transaction_date;
	 LocalTime transcation_time;
	 
	//--creating array of transaction details class objects to keep transaction details--//
	TransactionDetails[] transactionArray = new TransactionDetails[100] ;
	int transactionCount=0;
	
	
////////////////////////////-------->>Constructors<<---------////////////////////////////////
	
	public BankAccount() {
		
	}
	
	public BankAccount(long accountNumber, String accountHolderName, double balance, String isActive) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.isActive = isActive;
		
		
	}




////////////////////////////-------->>Setters-Getters<<---------////////////////////////////////
	
	
	public long getAccountNumber() {
		return accountNumber;
	}

	public LocalDate getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(LocalDate transaction_date) {
		this.transaction_date = transaction_date;
	}

	public LocalTime getTranscation_time() {
		return transcation_time;
	}

	public void setTranscation_time(LocalTime transcation_time) {
		this.transcation_time = transcation_time;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getisActive() {
		return isActive;
	}

	public void setisActive(String isActive) {
		this.isActive = isActive;
	}
	


	public TransactionDetails[] getTransactionArray() {
		return transactionArray;
	}

	public void setTransactionArray(TransactionDetails[] transactionArray) {
		this.transactionArray = transactionArray;
	}

	public int getCounttrans() {
		return transactionCount;
	}

	public void setCounttrans(int counttrans) {
		this.transactionCount = counttrans;
	}


	
////////////////////////////-------->>Cash deposit<<---------////////////////////////////////

public  void  cashDeposit(double amount) {
		//--creating an object of transaction details class to connect it here--//
	TransactionDetails object=new TransactionDetails(amount,"Deposit");
		
		this.balance += amount;
			transactionArray[transactionCount++]=object;
			System.out.println("Deposited: " + amount);
	}

	
////////////////////////////-------->>Display<<---------////////////////////////////////
	
	public void  display() {
		
			
				System.out.println("Account Details: ");
				System.out.println("Account Number: " + this.accountNumber);
				System.out.println("Account Holder name: " + this.accountHolderName);
				System.out.println("Account Current Balance : " + this.balance);
				System.out.println("Account status: " + this.isActive);
				
				
			
		
	}

	
	//--ABSTRACT FUNCTIONS THAT WILL BE OVERRIDEN IN DERIVED CLASSES--//
    
	public abstract void CalculateROI();
	public abstract void cashWithdraw(double amount);
//	public abstract void fundTransfer(double amount);

	
	 
}
