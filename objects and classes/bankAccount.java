package java_class_and_obj;

public class bankAccount {
	String accountHolder;
	double accountNumber;
	int balance;
	
bankAccount(String accountHolder,double accountNumber,int balance){
	this.accountHolder=accountHolder;
	this.accountNumber=accountNumber;
	this.balance=balance;
	
}
public void deposit(int amount) {
	if(amount>0) {
		balance+=amount;
		System.out.println("balance after deposit is: "+balance);
		
	}else {
		System.out.println("enter valid amount");
	}
}	
public void withdraw(int amount) {
	if(amount>0 && balance>amount) {
		balance-=amount;
		System.out.println("balance after withdraw is: "+balance);
}else {
	System.out.println("enter valid amount");
}	
}
public void displayInfo() {
	System.out.println("account holder name is: "+accountHolder);
	System.out.println("account Number is: "+accountNumber);
	System.out.println("balance is: "+balance);
	
}
public static void main(String[]args) {
	bankAccount b1=new bankAccount("harshit",67855898,570000);
	
	b1.displayInfo();
	b1.deposit(90000);
	b1.withdraw(7000);
}
}
