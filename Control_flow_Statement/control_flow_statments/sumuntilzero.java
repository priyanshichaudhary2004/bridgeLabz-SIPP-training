package control_flow_statments;
import java.util.*;
public class sumuntilzero {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int sum = 0;
       
        while(true) {
        	 System.out.println("enter number");
             int num=sc.nextInt();
             sum+=num;
             
            if(num<=0) {
            	break;
            }
        }
        System.out.println("sum is: "+ sum);
        
        
        

}
}