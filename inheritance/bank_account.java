package inheritance;
//Superclass
class BankAccount {
 String accountNumber;
 double balance;

 public BankAccount(String accountNumber, double balance) {
     this.accountNumber = accountNumber;
     this.balance = balance;
 }

 public void displayDetails() {
     System.out.println("Account Number: " + accountNumber);
     System.out.println("Balance: ₹" + balance);
 }

 public void displayAccountType() {
     System.out.println("Generic Bank Account");
 }
}

//Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
 double interestRate;

 public SavingsAccount(String accountNumber, double balance, double interestRate) {
     super(accountNumber, balance);
     this.interestRate = interestRate;
 }

 @Override
 public void displayAccountType() {
     System.out.println("Account Type: Savings Account");
 }

 public void displayDetails() {
     super.displayDetails();
     System.out.println("Interest Rate: " + interestRate + "%");
 }
}

//Subclass: CheckingAccount
class CheckingAccount extends BankAccount {
 double withdrawalLimit;

 public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
     super(accountNumber, balance);
     this.withdrawalLimit = withdrawalLimit;
 }

 @Override
 public void displayAccountType() {
     System.out.println("Account Type: Checking Account");
 }

 public void displayDetails() {
     super.displayDetails();
     System.out.println("Withdrawal Limit: ₹" + withdrawalLimit);
 }
}
class FixedDepositAccount extends BankAccount {
 int termInMonths;

 public FixedDepositAccount(String accountNumber, double balance, int termInMonths) {
     super(accountNumber, balance);
     this.termInMonths = termInMonths;
 }


 public void displayAccountType() {
     System.out.println("Account Type: Fixed Deposit Account");
 }

 public void displayDetails() {
     super.displayDetails();
     System.out.println("Term Duration: " + termInMonths + " months");
 }
}




public class bank_account {
	 public static void main(String[] args) {
	        SavingsAccount sa = new SavingsAccount("SA12345", 10000.0, 4.5);
	        CheckingAccount ca = new CheckingAccount("CA54321", 8000.0, 2000.0);
	        FixedDepositAccount fda = new FixedDepositAccount("FD67890", 50000.0, 12);

	        System.out.println("=== Savings Account ===");
	        sa.displayAccountType();
	        sa.displayDetails();

	        System.out.println("\n=== Checking Account ===");
	        ca.displayAccountType();
	        ca.displayDetails();

	        System.out.println("\n=== Fixed Deposit Account ===");
	        fda.displayAccountType();
	        fda.displayDetails();
	    }
}
