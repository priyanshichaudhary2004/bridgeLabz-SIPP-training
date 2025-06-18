package control_flow_statments;
import java.util.*;
public class greatestfactor {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        if (number <= 1) {
            System.out.println("Please enter a number greater than 1.");
            return;
        }

        int greatestFactor = 1;
        for(int i=number-1; i>1;i--) {
        	if(number%i==0) {
        		 greatestFactor = i;
        		 break;
        	}
        	 
        }
        System.out.println("Greatest factor of " + number + " (beside itself) is: " + greatestFactor);
        

}
}