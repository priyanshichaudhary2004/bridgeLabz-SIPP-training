import java.util.Scanner;
public class QuotientAndRemainder {
	public static int[] findQuotientAndRemainder(int number, int divisors) {
		int[] results = new int[2];
		results[0] = number / divisors;
		results[1] = number % divisors;
		return results;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number, divisors;
		
		System.out.print("Enter the number (dividend) : ");
		number = sc.nextInt();
		System.out.print("Enter the divisors : ");
		divisors = sc.nextInt();
		
		if(divisors == 0) {
			System.out.println("Please enter a valid number.");
		} else {
			int[] results = findQuotientAndRemainder(number, divisors);
			System.out.println("Quotient : " + results[0]);
			System.out.println("Remainder : " + results[1]);
		}
	}

}
