package control_flow_statments;

import java.util.Scanner;

public class sum_naturalnum2 {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter n");
		int n=sc.nextInt();
		if(n<=0){
			System.out.println("enter a natural number");
			
		}else {
			int formulaSum= n*(n+1)/2;
			
			
			int loopSum=0;
			for(int i=0;i<=n;i++) {
				loopSum+=i;
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


