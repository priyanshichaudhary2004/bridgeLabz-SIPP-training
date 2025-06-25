package oops;

class BankAccount1{
	 
		public double accountNumber ;
		protected String accountHolder ;
		private double balance;
		
		BankAccount1( double accountNumber, String accountHolder,double balance){
			this.accountNumber=accountNumber;
			this.accountHolder=accountHolder;
			this.balance=balance;
		}
		public double getbalance() {
			return balance;
		}
		public void setbalance(double balance) {
			this.balance=balance;
		}
		public void displayInfo() {
			System.out.println("Account number is: "+accountNumber);
			System.out.println("Account holder name is: "+accountHolder);
			System.out.println("Account balance is: "+balance);
		}
		
}
class SavingsAccount extends BankAccount1{
	SavingsAccount(double accountNumber, String accountHolder,double balance){
		super(accountNumber, accountHolder , balance);
		
	}public void displayInfoSavingAccount() {
		System.out.println("Account number is: "+accountNumber);
		System.out.println("Account holder name is: "+accountHolder);
		System.out.println("Account balance is: "+getbalance());
	}
	
}

public class bankaccount {
	public static void main(String[]args) {
		BankAccount1 b1=new BankAccount1(12446900,"harshit",890000);
		b1.displayInfo();
		
		SavingsAccount s1=new SavingsAccount(12567833,"priyanshi",999000);
		s1.getbalance();
		s1.displayInfoSavingAccount();
		
		
	}

}
