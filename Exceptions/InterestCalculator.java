import java.util.Scanner;

public class InterestCalculator {

    // Method that may throw IllegalArgumentException
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive");
        }
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter principal amount : ");
            double amount = sc.nextDouble();

            System.out.print("Enter rate of interest : ");
            double rate = sc.nextDouble();

            System.out.print("Enter number of years : ");
            int years = sc.nextInt();

            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated Interest : " + interest);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }
}
