import java.util.Scanner;

// ----- Basic Banking Transactions Demo ----

public class BankingDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String c_name;    			// customer name
		String c_account;			// customer account
		
		System.out.println("Please Enter the your name  : ");
		c_name = scanner.next();
		
		System.out.println("Please Enter the your account  : ");
		c_account = scanner.next();
		
		BankAccount obj1 = new BankAccount(c_name, c_account);
		obj1.showMenu();
		
		scanner.close();
	}
}

class BankAccount{
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	BankAccount(String c_name, String c_id){
		customerName = c_name;
		customerId = c_id;
	}
	
	void menu() {
		System.out.println("============================================================= ");
		System.out.println(" P l e a s e    S e l e c t    a n    O p t i o n   ( A - E )");
		System.out.println("============================================================= ");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
	}
	
	void deposit(int amount) {
		if(amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;  // setting previousTransaction to positive (deposited)
		}
	}
	
	void withdraw(int amount){
		if(amount !=0 ) {
			balance = balance - amount;
			previousTransaction = -amount;  // setting previousTransaction to negative (withdrawn)
		}		
	}
	
	void getPreviousTransaction() {
		if(previousTransaction > 0)
			System.out.println("Deposited : " + previousTransaction);
		
		else if(previousTransaction < 0)
			System.out.println("Withdrawn : " + Math.abs(previousTransaction));
		
		else 
			System.out.println("--- No transaction Occured ---");	
	}
	
	void showMenu() {
		
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("W  E  L  C  O  M  E   " + customerName);
		System.out.println("I D  :  " + customerId);
		System.out.println("\n");
		menu();
				
		do {		
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch(option) {
			
			case 'A' :
				System.out.println("------------------------------------------------------------ ");
				System.out.println("Balance " +  balance);
				System.out.println("------------------------------------------------------------ ");
				menu();
				System.out.println("\n");
				break;
				
			case 'B':
				System.out.println("------------------------------------------------------------ ");
				System.out.println("Enter amount to deposit ");
				System.out.println("------------------------------------------------------------ ");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println("\n");
				menu();
				System.out.println("\n");
				break;
				
			case 'C':
				System.out.println("------------------------------------------------------------ ");
				System.out.println("Enter amount to withdraw ");
				System.out.println("------------------------------------------------------------ ");
				int withdraw_amount = scanner.nextInt();
				withdraw(withdraw_amount);
				System.out.println("\n");
				menu();
				System.out.println("\n");
				break;
				
			case 'D':
				System.out.println("------------------------------------------------------------ ");
				getPreviousTransaction();
				System.out.println("------------------------------------------------------------ ");
				menu();
				System.out.println("\n");
				break;
				
			case 'E' :
				break;
				
			default:
				System.out.println("Invalid Option Selected : Please Enter Again \n");
				menu();
				System.out.println("\n");
				break;
			}
		}while(option != 'E');
		
		scanner.close();
		System.out.println("*************************************");
		System.out.println("   ----  T H A N K   Y O U  ----");
		System.out.println("*************************************");
	}	
}