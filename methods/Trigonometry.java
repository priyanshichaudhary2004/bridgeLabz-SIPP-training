import java.util.Scanner;
public class Trigonometry {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double angle;
		
		System.out.print("Enter the angle in degrees : ");
		angle = sc.nextDouble();
	
		double[] values = calculateTrigonometricFunctions(angle);
		
		System.out.printf("Sine(%.2f°)      = %.4f%n", angle, values[0]);
		System.out.printf("Cosine(%.2f°)    = %.4f%n", angle, values[1]);
		System.out.printf("Tangent(%.2f°)   = %.4f%n", angle, values[2]);
	}
	
	public static double[] calculateTrigonometricFunctions(double angle) {
		double radians = Math.toRadians(angle);
		
		double[] results = new double[3];
		results[0] = Math.sin(radians);
		results[1] = Math.cos(radians);
		results[2] = Math.tan(radians);
		
		return results;
	}

}
