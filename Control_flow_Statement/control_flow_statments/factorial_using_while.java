package control_flow_statments;
import java.util.*;
public class factorial_using_while {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter a positive integer: ");
	        int number = sc.nextInt();

	        if (number < 0) {
	            System.out.println(" enter a positive integer.");
	        } else {
	            int factorial = 1;
	            int i = 1;
	            while (i <= number) {
	                factorial *= i;
	                i++;
	            }
	            System.out.println("Factorial of " + number + " is: " + factorial);
	        }
	

}
}