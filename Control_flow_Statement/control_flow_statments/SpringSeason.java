package control_flow_statments;

import java.util.Scanner;

public class SpringSeason {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter month");
		int month=sc.nextInt();
		System.out.println("enter day");
		int day=sc.nextInt();
		
		boolean IsSpring=false;
		
		if((month==3 && day>=20 && day<=31) ||
			(month==4 && day>=1 && day<=30) ||
			(month==5 && day>=1 && day<=31) ||
			(month==6 && day>=1 && day<=20)) {
			 IsSpring=true;
		}
		if(IsSpring) {
			System.out.println("it's Spring season");
		}else {
			System.out.println("it's not Spring season");
			
		}
		

}
}