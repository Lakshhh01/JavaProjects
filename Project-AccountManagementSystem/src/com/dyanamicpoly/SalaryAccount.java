package com.dyanamicpoly;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Scanner;

public class SalaryAccount extends BankAccount{
	 static double minimunBalance = 10000;
	 static double rate=0.034;
	 LocalDate transaction_date;
	 LocalTime transcation_time=null;
	 Scanner sc=new Scanner(System.in);
	 
	 
////////////////////////////-------->>Constructors<<---------////////////////////////////////
	 
	 
	public SalaryAccount() {
		// TODO Auto-generated constructor stub
	}
	
	public SalaryAccount(long accountNumber, String accountHolderName, double balance, String isActive, LocalDate transaction_date ,LocalTime transaction_time) {
        super(accountNumber, accountHolderName, balance, isActive);
        
        
//        this.transaction_date = LocalDate.now().minusMonths(2);
        this.transaction_date = LocalDate.now().minusMonths(0);
        this.transcation_time=null;
    }
	


////////////////////////////-------->>setters-getters<<---------////////////////////////////////
	
	public LocalDate getTransaction_date() {
		return transaction_date;
	}
	
	public LocalTime getTranscation_time() {
		return transcation_time;
	}
	
	public void setTransaction_date(LocalDate transaction_date) {
		this.transaction_date = transaction_date;
	}
	public void setTranscation_time(LocalTime transcation_time) {
		this.transcation_time = transcation_time;
	}



////////////////////////////-------->>Display<<---------////////////////////////////////
	public void display() {
		System.out.println("\n****Salary acount details****\n");
		super.display();
	}
	
	
	
////////////////////////////-------->>ROI<<---------////////////////////////////////

	@Override
	public void CalculateROI() {
		 System.out.println("Rate of interest of Salary account:" + SalaryAccount.rate) ;
				
		return ;
	}

	

/////////////////////////////////----------->>freeze<<------------///////////////////////////////

public boolean isfreeze() {
	if(transactionCount>0) {
		LocalDate c=LocalDate.now();
		LocalDate lasttransaction=transactionArray[transactionCount].getTransactionDate();
	
	Period p=lasttransaction.until(c);

		if(p.getMonths()>=2) {
			this.setisActive("freezed");
			System.err.println(("Transaction gap greater than two months"));
			return true;
		}
	}
	
	return false;

}

////////////////////////////-------->>Cash withdrawl<<---------////////////////////////////////

	public void cashWithdraw(double amount) {
		
	    // Check if the account is frozen
		LocalDate c=LocalDate.now();
		
//		LocalDate lasttransaction=transactionArray[transactionCount].getTransactionDate();
	
		Period p=transaction_date.until(c);

		if(p.getMonths()>=2) {
			this.setisActive("freezed");
			System.err.println(("Transaction gap greater than two months"));
			

		}
		
	    if (this.getisActive()=="freezed") {
	        System.out.println("Account is frozen. Cannot withdraw money.");
	        return;
	    }	   
	    	
    	try {
    		if (balance <= SalaryAccount.minimunBalance) {
    			
    			throw new InsufficientBalanceException("Insufficient Balance");
    		} 
    		else {
		        this.balance -= amount;
		        // Creating an object of the TransactionDetails class to connect it here
		        TransactionDetails object = new TransactionDetails(amount,"withdraw");
		        

		        System.out.println("Amount withdrawl successfull");
		        
		            transactionArray[transactionCount++] = object;			        
		    }
    	}catch(InsufficientBalanceException e) {
    		System.err.println("Error Occurred: " + e.getMessage());
    	}
		    
   }

/////////////////////////////////----------->>cash Deposit<<------------///////////////////////////////

	@Override
	public void cashDeposit(double amount) {
		
		if (this.getisActive()=="freezed") {
	        System.out.println("Account is frozen. Cannot withdraw money.");
	        return;
	    }
		
		try {
			this.balance += amount;

			// Creating an object of the TransactionDetails class to connect it here
			TransactionDetails object = new TransactionDetails(amount, "deposit");

			//account is not freezed->then only update date and time

			object.setTransactionDate(LocalDate.now());
			object.setTransactionTime(LocalTime.now());
			transactionArray[transactionCount++] = object;
			System.out.println("Amount Deposited successfully...!");
		} catch (Exception e) {
			
			// TODO: handle exception
		}
	        
	        
		
		
			
		
	}



}
	
	
	
	
/*	

////////////////////////////----------->>Fund Transfer<<-------------////////////////////////

public  void fundTransfer(double amount) {
// Check if the account is frozen
if (this.getisActive()=="freezed") {
System.out.println("Account is frozen. Cannot transfer money.");
return;
}



try {
if (balance <= SalaryAccount.minimunBalance) {

throw new InsufficientBalanceException("Insufficient Balance");
} 
else {
this.balance -= amount;
// Creating an object of the TransactionDetails class to connect it here
TransactionDetails object = new TransactionDetails(amount,"fund transfer");


System.out.println("Amount Transferred successfull");
transactionArray[transactionCount++] = object;			        
}
}catch(InsufficientBalanceException e) {
System.err.println("Error Occurred: " + e.getMessage());
}

}
*/

	
	
	


