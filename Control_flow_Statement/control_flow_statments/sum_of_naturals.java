package control_flow_statments;

import java.util.Scanner;

public class sum_of_naturals {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter n");
		int n=sc.nextInt();
		if(n<=0){
			System.out.println("the number"+ n+ " is not a natural number");
			
		}else {
			
			int Sum=0;
			for(int i=0;i<=n;i++) {
				Sum+=i;
			}
			
			System.out.println("sum of"+" " + n + "natural number is"+ Sum);
			
			
		
		
			
	}


}
}
