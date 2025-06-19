import java.util.*;
public class BMI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of persons: ");
		int n =sc.nextInt();
		double[] weight = new double[n];
		double[] height = new double[n];
		double[] bmi = new double[n];
		String[] status =new String[n];
		for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Person " + (i + 1));
            System.out.print("Weight (in kg): ");
            weight[i] = sc.nextDouble();

            System.out.print("Height (in meters): ");
            height[i] = sc.nextDouble();
        }
		for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi[i] <= 24.9) {
                status[i] = "Normal";
            } else if (bmi[i] <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
		 System.out.println("\n--- BMI Report ---");
	        for (int i = 0; i < n; i++) {
	            System.out.printf("Person %d:\n", (i + 1));
	            System.out.printf("  Height: %.2f m\n", height[i]);
	            System.out.printf("  Weight: %.2f kg\n", weight[i]);
	            System.out.printf("  BMI: %.2f\n", bmi[i]);
	            System.out.printf("  Status: %s\n", status[i]);
	            System.out.println();
	        }
	}

}
