import java.util.Scanner;
public class SimpleInterest {
	public static double calculateSI(double principal, double rate, double time) {
		return (principal * rate * time) / 100;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double principal, rate, time;
		
		System.out.print("Enter principal : ");
		principal = sc.nextDouble();
		System.out.print("Enter rate : ");
		rate = sc.nextDouble();
		System.out.print("Enter time : ");
		time = sc.nextDouble();
		
		double simpleInterest = calculateSI(principal, rate, time);
		
		System.out.println("The Simple Interest is " + simpleInterest + " for Principal " 
				+ principal + " , Rate of Interest " + rate + " and Time " + time);
	}
}
