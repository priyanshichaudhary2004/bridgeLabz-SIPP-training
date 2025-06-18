package control_flow_statments;
import java.util.*;
public class factorial {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter a positive integer: ");
	        int number = sc.nextInt();

	        if (number < 0) {
	            System.out.println(" enter a positive integer.");
	        } else {
	            int factorial = 1;
	            for (int i = 1; i <= number; i++) {
	                factorial *= i;  
	            }
	            System.out.println("Factorial of " + number + " is: " + factorial);
	        }
	

}
}