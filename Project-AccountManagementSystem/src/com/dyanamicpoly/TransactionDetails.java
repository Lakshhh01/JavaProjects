package com.dyanamicpoly;

import java.time.LocalDate;
import java.time.LocalTime;
//import java.util.Date;
//import java.util.Timer;

public class TransactionDetails {
	
	static int transactionCountNumber=0;		//keeps track of number of transactions//
	
	
	String transactionId;

	LocalDate transactionDate;
	LocalTime transactionTime;	
	double transactionAmount;
	String transactionType;

////////////////////////////////////-------->>Constructors<<---------////////////////////////////////
	
	public TransactionDetails() {
		
	}
	
	public TransactionDetails(double transactionAmount, String transactionType) {
//		this.transactionDate = LocalDate.now().minusMonths(2);
		this.transactionDate = LocalDate.now().minusMonths(0);
		this.transactionTime = LocalTime.now();
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		
		/*whenever the transaction object will be created ,unique id will be generated //
		->This concatenates the string representations of transactionDate,
		transactionTime, and transactionCountNumber using the + operator.
		*/ 
		this.transactionId =generateTransactionId();
	}
	
	
	
////////////////////////////-------->>Setters-Getters<<---------////////////////////////////////
	
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public LocalTime getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(LocalTime transactionTime) {
		this.transactionTime = transactionTime;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getTransactionCountNumber() {
		return transactionCountNumber;
	}
	public void setTransactionCountNumber(int transactionCountNumber) {
		TransactionDetails.transactionCountNumber = transactionCountNumber;
	}
	
	
///////////////////////--------->>Transaction Id generation<<----------//////////////////////////
	
	public String generateTransactionId(){
		
//		String.valueof()->string method
//		
//		1)If the argument is a primitive type (e.g., int, double, etc.), it converts it to a string representation.
//		2) If the argument is an object, it calls the object's toString method and returns the result.//
		
		
		return (String.valueOf(this.transactionDate) + String.valueOf(this.transactionTime) + TransactionDetails.transactionCountNumber);
//		->This concatenates the string representations of transactionDate,
//		transactionTime, and transactionCountNumber using the + operator. 
		
		
	}
	
	
	
//////////////////////////////////////-------->>Display<<---------////////////////////////////////

	
	public void display() {
		
			
			System.out.println("\n***TRANSACTION DETAILS*\n");
			System.out.println("Transaction Id: " + generateTransactionId() );
			System.out.println("Transaction type:" + this.transactionType);
			System.out.println("Transaction Amount: " + this.transactionAmount);
			System.out.println("Transaction Timestamp: " + this.transactionTime);	
		
		
		
	}
	

}