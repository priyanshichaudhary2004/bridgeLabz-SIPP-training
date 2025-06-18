package control_flow_statments;
import java.util.*;
public class odd_and_even {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter a natural number: ");
	        int number = sc.nextInt();

	        if (number <= 0) {
	            System.out.println("Please enter a natural number .");
	        } else {
	        	for(int i=0;i<number;i++) {
	        		if(i%2==0) {
	        			System.out.println("even  number is:"+i);
	        		}else {
	        			System.out.println("odd  number is:"+i);
	        		}
	        	}
	        }

}
}