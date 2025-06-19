import java.util.Scanner;
public class WindChill {
	public static double calculateTemperature(double temperature, double windSpeed) {
		return 35.74 + (0.6215 * temperature) + 
				(0.4275 * temperature - 35.75) * Math.pow(windSpeed,  0.16); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		double temperature, windSpeed;
		
		System.out.print("Enter the temperature : ");
		temperature = sc.nextDouble();
		System.out.print("Enter the windchill speed : ");
		windSpeed = sc.nextDouble();
		
		if(temperature <= 50 && windSpeed > 3) {
			double windChill = calculateTemperature(temperature, windSpeed);
			System.out.printf("The wind chill temperature is : %.2f°F\n", windChill);
		} else {
			System.out.println("Note: Wind chill formula is only valid for "
					+ "temperatures ≤ 50°F and wind speeds > 3 mph.");
		}
	}

}
