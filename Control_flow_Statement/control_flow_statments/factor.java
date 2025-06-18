package control_flow_statments;
import java.util.Scanner;
public class factor {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter a positive integer: ");
	        int number = sc.nextInt();

	        if (number <= 0) {
	            System.out.println("Please enter a positive integer.");
	        } else {
	            System.out.println("Factors of " + number + " are:");
	            int counter=1;
	            while(number>=counter) {
	            	if(number%counter==0) {
	            		System.out.println("factor is: "+counter);
	            	}counter++;
	            }
	            

}
}
}