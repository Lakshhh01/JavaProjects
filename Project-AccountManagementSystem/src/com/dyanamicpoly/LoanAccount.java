package com.dyanamicpoly;
import java.util.Scanner;

public class LoanAccount extends BankAccount{
	Scanner sc=new Scanner(System.in);
	
	static double ROI=0.09;
	
	double monthly_income;
	double duration_of_loan;
	
	
////////////////////////////-------->>Constructors<<---------////////////////////////////////
	
	public LoanAccount() {
		
		
	}
	
	public LoanAccount(long accountNumber, String accountHolderName, double balance, String isActive,double duration_of_loan,double monthlyincome) {
		super( accountNumber,  accountHolderName,  balance, isActive);
		this.monthly_income=monthlyincome;
		this.duration_of_loan = duration_of_loan;

	}

	
////////////////////////////-------->>setters-getters<<---------////////////////////////////////

	
	public void setMonthlyIncome(double m) {
		this.monthly_income=m;
	}
	
	public double getMonthlyIncome() {
		return this.monthly_income;
	}
	public double getDuration_of_loan() {
		return duration_of_loan;
	}

	public void setDuration_of_loan(int duration_of_loan) {
		this.duration_of_loan = duration_of_loan;
	}
	

////////////////////////////-------->>Display<<---------////////////////////////////////
	
	public void display() {
		
		System.out.println("****Loan Account Details****");
		super.display();
		System.out.println("Account Current Balance : " + this.balance +" lacs");
		System.out.println("Time duration of Loan provided: " + this.duration_of_loan);
	
	}
	
	
///////////////////////////------------>>Loan availability<<----------/////////////////////////
	
	public int isLoanAvailable() {
		double monthlyincome=this.getMonthlyIncome();
		
		if(monthlyincome>=1000) {
			System.out.println("Loan will be available checking for conditions...");
			
			// Check income
			if (monthlyincome>=100000) {
		        System.out.println("Loan will be issued upto 50 lacs");
		        return 50;
		       
		    }
			else if ( monthlyincome<100000 && monthlyincome>=50000) {
				 System.out.println("Loan will be issued upto 40 lacs");
				 return 40;
		       
		    }
			else if (monthlyincome <50000 && monthlyincome>=20000) {
				 System.out.println("Loan will be issued upto 30 lacs");
				 return 30;
		       
		    }
			else if (monthlyincome < 20000 && monthlyincome>=10000) {
				 System.out.println("Loan will be issued upto 20 lacs");
				 return 20;
		    }
			
			else {
		        System.out.println("Loan will be issued upto 10 lacs");
		        return 10;
		    }
			
		}
		else {
			System.out.println("You are not eligible.. for Loan Sanction");
			return 0;
		}
	    
		
		
	}

	
	
	
//////////////////////////////>>------Calculate emi--------<</////////////////////////////	


public double CalculateEMI(double income) {
	if(isLoanAvailable()!=0) {
	
		double principal = income;
		double monthlyInterestRate = ROI / 12.0; // Monthly interest rate
		int numberOfPayments = (int) (duration_of_loan * 12); // Total number of payments (loan tenure in months)
		
		
		double emi = (principal * monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPayments))
		/ (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1);
		System.out.println("Calculated Emi:" + emi);
		return emi;
	}
	else {
	
		return 0.0;
	}


}

	
	
////////////////////////////-------->>ROI<<---------////////////////////////////////
	
	@Override
	public void CalculateROI() {
		 System.out.println("rate of interest of Loan account:" + LoanAccount.ROI) ;
				
		return ;
	}
	
////////////////////////////-------->>Cash withdrawl<<---------////////////////////////////////


	@Override
	public void cashWithdraw(double amount) {

		
		this.balance-=amount;
		
		TransactionDetails object =new TransactionDetails(amount,"withdraw");
		System.out.println("amount withdrawl Successfully...");
		
		transactionArray[transactionCount++]=object;
		

	}
}
