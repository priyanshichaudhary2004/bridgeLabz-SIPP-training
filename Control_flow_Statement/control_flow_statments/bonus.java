package control_flow_statments;
import java.util.*;
public class bonus {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble();
        
        System.out.print("Enter your years of service: ");
        int years_of_Service = sc.nextInt();
        
        if(years_of_Service>5) {
        	double bonus=salary*(5/100.0);
        	 System.out.println("bonus is: "+ bonus);
        }else {
        	System.out.println("not eligible for bonus ");
        }
       

}
}