package control_flow_statments;
import java.util.*;
public class power {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter the base number: ");
	        int number = sc.nextInt();

	        System.out.print("Enter the power: ");
	        int power = sc.nextInt();

	        int result = 1;
	        int counter = 0;
	        while(counter<power) {
	        	result*=number;
	        	counter++;
	        }
	        
	        System.out.println("result is: "+ result);

}
}