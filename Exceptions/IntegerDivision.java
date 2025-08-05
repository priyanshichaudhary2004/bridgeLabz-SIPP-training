import java.util.Scanner;

public class IntegerDivision {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter numerator : ");
            int numerator = sc.nextInt();

            System.out.print("Enter denominator : ");
            int denominator = sc.nextInt();

            int result = numerator / denominator;
            System.out.println("Result : " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } finally {
            System.out.println("Operation completed.");
        }
    }
}
