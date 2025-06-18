package control_flow_statments;
import java.util.*;
public class rocketcountdown {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter starting countdown number: ");
        int counter = sc.nextInt();
        
        while(counter>0) {
        	System.out.println(counter);
        	counter--;
        	
        }
        System.out.println("rocket launched");
        

}
}