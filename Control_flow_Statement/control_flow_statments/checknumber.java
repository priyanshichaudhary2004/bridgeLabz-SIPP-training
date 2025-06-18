package control_flow_statments;

import java.util.Scanner;

public class checknumber {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter num");
		int num=sc.nextInt();
		if(num<0) {
			System.out.println(" num is negative");
		}else if(num==0) {
			System.out.println(" num is zero");
		}else {
			System.out.println("num is positive");
		}

}
}