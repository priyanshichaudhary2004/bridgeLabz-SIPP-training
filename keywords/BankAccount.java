package key_words;

public class BankAccount {
static String bankName="state Bank";
static int TotalAccounts=0;

String accountHolderName;
 final long accountNumber;

BankAccount(String accountHolderName, long accountNumber){
	this.accountHolderName=accountHolderName;
	this.accountNumber=accountNumber;
	TotalAccounts++;
}
public static void getTotalAccounts() {
	System.out.println("Total bank accounts: " + TotalAccounts);
}

public void displayInfo(Object obj) {
	if(obj instanceof BankAccount) {
		System.out.println("bank name is : "+ bankName);
		System.out.println("account holder name is : "+accountHolderName);
		System.out.println("account number is : "+accountNumber);
		
	
	}else {
		System.out.println("not a valid bankaccount ");
	}
}

public static void main (String[]args) {
	BankAccount account1=new BankAccount("harshit",23456789);
	BankAccount account2=new BankAccount("priyanshi",67899997);
	BankAccount account3=new BankAccount("aashi",357997);
	account1.displayInfo(account1);
	account2.displayInfo(account2);
		BankAccount.getTotalAccounts();
		account3.displayInfo(account3);

}

}
