package control_flow_statments;
import java.util.*;
public class vote {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter age: ");
	        int age = sc.nextInt();

	        if (age >= 18) {
	            System.out.println(" person can vote.");
	        } else {
	            System.out.println(" person cannot vote.");
	        }

}
}