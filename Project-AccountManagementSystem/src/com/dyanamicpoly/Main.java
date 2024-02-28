package com.dyanamicpoly;

import java.time.LocalDate;
import java.time.LocalTime;
//import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

		
    long accountNumber = generateRandomAccountNumber(); // Generate a random account number

    
	static int accountCount=0;		//maintains the number of count of accounts

	//--creating accounts array--//
	static BankAccount[] array_of_accounts = new BankAccount[100];
	
////////////////////////////-------->>Show Transaction Details<<---------////////////////////////////////
	
	
	public static void showTransactions(BankAccount[] array_of_accounts) {		//receiving the reference(pointer in cpp) of array of accounts//
		LocalDate currentDate = LocalDate.now();
		boolean transactionsFound = false;
		
		//looping thru bankaccount array//
		for(int i=0;i<accountCount;i++) {
			
			
			//--creating a variable of base class type to store each account object of array--// 
			BankAccount accountObject=array_of_accounts[i];
			
			System.out.println("\nTransactions for Account Number: " + accountObject.getAccountNumber());
			System.out.println("Account Holder: " + accountObject.getAccountHolderName());

			if(accountObject!=null) {
				
//				looping thru the array of transactions associated with i th account//
				for(int j=0;j<accountObject.getCounttrans();j++) {
					
					TransactionDetails transaction = accountObject.getTransactionArray()[j];
						
					if(transaction!=null && transaction.getTransactionDate().equals(currentDate)) {
						System.out.println("**** TRANSACTION DETAILS ****");
						System.out.println("Transaction Id: " + transaction.getTransactionId());
						System.out.println("Transaction Type: " + transaction.getTransactionType());
						System.out.println("Transaction Amount: " + transaction.getTransactionAmount());
						System.out.println("Transaction Date: " + transaction.getTransactionDate());
						System.out.println("Transaction Time: " + transaction.getTransactionTime());
						
						// Set flag to indicate transactions are found
	                    transactionsFound  = true;
						
						
					}
				}
			}
			
			//no transactions today//
		}
		 if (!transactionsFound) {
		        System.out.println("No transactions occurred today for the selected account.");
		    }
	}

	
//////////////////////////------------>>Generate account number<<---------/////////////////////
	
	public static long generateaccountnumber=1234567890;
	
	private static long generateRandomAccountNumber() {
		
		
			return generateaccountnumber++;
		
	}


////////////////////////////////////----------->>Search<<---------//////////////////////////////////////////////
	
	public static int search(long accountnumber) {
	    for (int i = 0; i < accountCount; i++) {
	        if (array_of_accounts[i].getAccountNumber() == accountnumber) {
	            return i;  // Return the index if found
	        }
	    }
	    return -1;  // Return -1 if not found
	}

////////////////////////////////////----------->>Create Account<<---------//////////////////////////////////////////////

	public static void createAccount(){
	
	int accountTypeChoice = 0;
	@SuppressWarnings("resource")
	Scanner sc=new Scanner(System.in);
	do {
		System.out.println("\n\n");
		System.out.println("=====================================");
		System.out.println("|        Select Account Type        |");
		System.out.println("|-----------------------------------|");
		System.out.println("|   1. Savings Account              |");
		System.out.println("|   2. Salary Account               |");
		System.out.println("|   3. Current Account              |");
		System.out.println("|   4. Loan Account                 |");
		System.out.println("|   5. Exit                         |");
		System.out.println("=====================================");
		boolean flag=false;
		
		while(flag==false) {
			try {
				System.out.print("Enter your choice: ");
				accountTypeChoice = sc.nextInt();
				flag=true;

			} catch (InputMismatchException ime) {
				System.err.println("Please enter valid ***INTEGER*** as input");
				sc.next();
			}
		}
		
                
        
         switch (accountTypeChoice) {
             
         //creating savings account.//
             case 1:{
               
                 System.out.println("Enter your name: ");
                 String name = sc.next();
                 System.out.println("Enter initial balance to deposit: ");
                 double balance = sc.nextDouble();
                
            	 if(balance<=Savings.minBalanceRequired) {
            		 System.out.println("Please enter atleast " + Savings.minBalanceRequired + " To proceed!");
            		 
            	 }
            	 
            	 else {
            		 
            		 BankAccount accountobject=new Savings(generateRandomAccountNumber(),name,balance,"active");
            		 array_of_accounts[accountCount]=accountobject;
            		 accountCount++;
            		 System.out.println(accountCount);
            		 System.out.println("Savings Account created successfully..!");
            		 accountobject.display();
            	 }
                 break;
             }
             
             //creating salary account//
             case 2:{
                
                 System.out.println("Enter your name: ");
                 String name = sc.next();
                 System.out.println("Enter initial balance to deposit: ");
                 double balance = sc.nextDouble();
                 
                 if(balance<=SalaryAccount.minimunBalance) {
            		 System.out.println("Please enter atleast " + SalaryAccount.minimunBalance+ " To proceed!");
            		 
            	 }
                 else {
                	 BankAccount accountobject = new SalaryAccount(generateRandomAccountNumber(), name, balance,"active", LocalDate.now(),LocalTime.now());
                	 array_of_accounts[accountCount] = accountobject;
                	 accountCount++;
                	 System.out.println("Salary Account created successfully..!");
                	 accountobject.display();
                	 
                 }
                 
         	    	
         	     
         	    
            	 break;
             }
           //creating Current account//
             case 3:{
                 
                 System.out.println("Enter your name: ");
                 String name = sc.next();
                 System.out.println("Enter initial balance to deposit: ");
                 double balance = sc.nextDouble();
                 
                 BankAccount accountobject=new CurrentAccount(generateRandomAccountNumber(),name,balance,"active");
        		 array_of_accounts[accountCount]=accountobject;
        		 accountCount++;
        		 System.out.println("Current Account created successfully..!");
        		 accountobject.display();
            	 break;
             }
             case 4:{
                
            	 System.out.println("Enter your name: ");
                 String name = sc.next();
                
                 System.out.println("Enter duration of loan: "); 
                 int duration=sc.nextInt();
                 System.out.println("Enter monthly income: "); 
                 double income=sc.nextDouble();
                
                 LoanAccount accountobject=new LoanAccount(generateRandomAccountNumber(),name,0.0,"active",duration,income);
                 if(accountobject.isLoanAvailable()!=0.0) {
        			 double loanamt=accountobject.isLoanAvailable();
        			 System.out.println("Loan available: "+ loanamt + "lacs");
        			 accountobject.display();
        		 }
                 //upcasting//
             	 BankAccount bankaccountobject = accountobject;
        		 array_of_accounts[accountCount]=bankaccountobject;
        		 accountCount++;
        		 System.out.println("Loan Account created successfully..!\n");
        		 
            	 break;
            	 
             }
             case 5:{
            	 System.out.println("Exiting From create account menu...");
            	 break;
             }
             
            
             default:
                 System.out.println("Invalid account type. Please enter a valid option.");
                 break;
         }
         
    	 
     }while(accountTypeChoice!=5);
	
}	
	
//////////////////////////////////////////////-------->>Main<<-------////////////////////////////////////////
	
	


	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int choice = 0;	
		
		do{
			
			System.out.println("|===========================================|");
            System.out.println("|          *Banking System Menu*            |");
            System.out.println("|===========================================|");
            System.out.println("|   Option  |          Description          |");
            System.out.println("| ----------|-------------------------------|");
            System.out.println("|     1     |      Create Account           |");
            System.out.println("|     2     | Display Account Details       |");
            System.out.println("|     3     |           Deposit             |");
            System.out.println("|     4     |          Withdraw             |");
            System.out.println("|     5     |     Calculate Interest        |");
            System.out.println("|     6     |         Fund Transfer         |");
            System.out.println("|     7     | Transaction Details For Today |");
            System.out.println("|     8     |         Close Account         |");
            System.out.println("|     9     |             Exit              |");
            System.out.println("|===========================================|");
            boolean flag=false;
    		
    		while(flag==false) {
    			try {
    				System.out.print("Enter your choice: ");
    				choice = sc.nextInt();
    				flag=true;

    			} catch (InputMismatchException ime) {
    				System.err.println("PLEASE ENTER VALID ***INTEGER*** AS INPUT");
    				sc.next();
    			}
    		}		
			
			switch(choice) {
			

				case 1:{
					createAccount();
					break;
				}
				case 2:{
		            System.out.println("***Displaying Account Details***");
		            System.out.println("Enter your account number: ");
		            long accno=sc.nextLong();
		            
		            int accountFound=search(accno);
		            
		            	if(accountFound!=-1) {
		            		array_of_accounts[accountFound].display();
		            		
			            	break;
			            }
		            	else{
			            	System.out.println("Account number not found!!");
			            }
	            	
		            
					 break;
				}
				
				//deposit//
				case 3:{
					 System.out.println("Enter account number for cash deposit: ");
					 long accno=sc.nextLong();
					 
					 int accountFound=search(accno);
					 if(accountFound!=-1) {
												
						System.out.println("Enter amount to deposit: ");
						double amount = sc.nextDouble();
						
						array_of_accounts[accountFound].cashDeposit(amount);
						
						break;
					}
					else {
						System.out.println("Account number not found! Can't deposit");
					}
					
					break;
				}
				case 4:{
					 System.out.println("Enter account number for cash withdrawl: ");
					 long accno=sc.nextLong();
					 
					 int accountFound = search(accno);
					if(accountFound!=-1) {
						
						System.out.println("Enter amount to withdraw : ");
						double amount = sc.nextDouble();
						
						array_of_accounts[accountFound].cashWithdraw(amount);
						
						break;
					}
					else {
						System.out.println("Account number not found! Can't withdraw");
					}
					
					 break;
				}
				case 5:{
					System.out.println("Enter account number: ");
					 long accno=sc.nextLong();
					 
					 int accountFound = search(accno);
					
					if(accountFound!=-1) {
						 System.out.println(" Calculating Interest...");
						 array_of_accounts[accountFound].CalculateROI();
						 
						break;
					}
					else {
						System.out.println("Account number not found! Can't calculate");
					}
					
					
		           
					 break;
				}
//				
//				case 6:{
//					System.out.println("Enter account number to transfer fund from: ");
//					 long accno=sc.nextLong();
//					 
//					 int accountFound = search(accno);
//					
//					if(accountFound!=-1) {
//						 System.out.println("Processing...");
//						
//							System.out.println("Enter amount to withdraw : ");
//							double amount = sc.nextDouble();
//						 array_of_accounts[accountFound].fundTransfer(amount);
//						 
//						break;
//					}
//					else {
//						System.out.println("Account number not found! Can't TRansfer");
//					}
//					break;
//				}
				case 7:{
		            System.out.println("-----------Transaction Details for the Day--------");
		            showTransactions(array_of_accounts);
					 break;
				}
				case 8:{
					System.out.println("Enter account number : ");
					long accno=sc.nextLong();
					
					int accountFound=search(accno);
						
						if(accountFound!=-1) {					
							System.out.println("Closing account...");
							array_of_accounts[accountFound].setisActive("Deactivated");
							break;
						}
						
					
					System.out.println("Account Closed...");
					break;
					
				}
				case 9:{
					System.out.println("Quiting...");
					break;
				}
				
				default:{
					System.out.println("Please Enter valid choice!!");
					break;
				}
			}
			
		}while(choice!=9);
	
	}
	



}

