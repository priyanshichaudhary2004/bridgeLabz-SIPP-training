import java.util.Scanner;

public class BankTransactionSystem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial balance : ");
        double initialBalance = sc.nextDouble();

        BankAccount account = new BankAccount(initialBalance);

        System.out.print("Enter withdrawal amount : ");
        double amount = sc.nextDouble();

        try {
            account.withdraw(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
	}
}
