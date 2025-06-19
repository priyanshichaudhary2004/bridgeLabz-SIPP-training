import java.util.Scanner;
public class Athlete {
	public static int calculateRounds(double side1, double side2, double side3) {
		double perimeter = side1 + side2 + side3;
		double totalDistance = 5000.0;
		return (int)Math.ceil(totalDistance / perimeter);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double side1, side2, side3;
		
		System.out.print("Enter the length of side 1 (in meters) : ");
		side1 = sc.nextDouble();
		System.out.print("Enter the length of side 2 (in meters) : ");
		side2 = sc.nextDouble();
		System.out.print("Enter the length of side 3 (in meters) : ");
		side3 = sc.nextDouble();
		
		int rounds = calculateRounds(side1, side2, side3);
		System.out.println("The athlete must complete " + rounds + 
				" rounds to complete a 5 km rum.");
	}

}
