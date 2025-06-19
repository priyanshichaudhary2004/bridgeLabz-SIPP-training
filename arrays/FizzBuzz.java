import java.util.*;
public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num =sc.nextInt();
		if(num>0) {
			String []res =new String[num];
			for(int i =1;i<=num;i++) {
				if( i % 3 ==0 && i% 5==0) {
					res[i-1]="FizzBuzz";
				}
				else if( i % 3 ==0) {
					res[i-1]="Fizz";
				}
				else if(i % 5 ==0) {
					res[i-1] ="Buzz";
				}
				else {
					res[i-1]=String.valueOf(i);
				}
				
			}
			for(int i =0;i<num;i++) {
				System.out.println("Position " + (i+1) + " = " +res[i] );
			}
		}
		else {
			System.out.println("Please enter a positive number");
		}

	}

}
