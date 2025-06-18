package control_flow_statments;
import java.util.*;
public class sum_naturalnum {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter n");
		int n=sc.nextInt();
		if(n<=0){
			System.out.println("enter a natural number");
			
		}else {
			int formulaSum= n*(n+1)/2;
			
			int i=1;
			int loopSum=0;
			while (i<=n) {
				loopSum+=i;
				i++;
			}
			System.out.println("sum using formula is"+ formulaSum);
			System.out.println("sum using loop is"+ loopSum);
			
			if(formulaSum==loopSum) {
				System.out.println("both result is same");
				
			}else {
				System.out.println("both result is not same");
			}
			
		}
		
		
			
	}

}
