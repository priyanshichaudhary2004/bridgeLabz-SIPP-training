package control_flow_statments;
import java.util.*;
public class coundown_using_for {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter starting countdown number: ");
        int counter = sc.nextInt();
        
        for(int i=counter;i>0;i--) {
        	System.out.println(counter);
        	counter--;
        	
        }
        System.out.println("rocket launched");
        

}

}
