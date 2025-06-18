package control_flow_statments;
import java.util.*;
public class largest_number {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter value for num 1: ");
	        int num_1 = sc.nextInt();

	        System.out.print("Enter value for num 2: ");
	        int num_2 = sc.nextInt();

	        System.out.print("Enter value for num 3: ");
	        int num_3 = sc.nextInt();
	        
	        boolean Isfirstlargest=(num_1>num_2)&&(num_1>num_3);
	        boolean Issecondlargest=(num_2>num_1)&&(num_2>num_3);
	        boolean Isthirdlargest=(num_3>num_1)&&(num_3>num_2);
	        
	        if((num_1==num_2)&&(num_2==num_3)) {
	        	System.out.println("all the numbers are same");	        }
	        
	        System.out.println("Is the first number the largest?"+Isfirstlargest);
	        System.out.println("Is the second number the largest?"+Issecondlargest);
	        System.out.println("Is the third number the largest?"+Isthirdlargest);
	        
	        


}
}
