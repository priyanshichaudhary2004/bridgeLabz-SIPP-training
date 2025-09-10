import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IoTSensorReadings {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of sensor readings : ");
        int n = sc.nextInt();

        System.out.print("Enter threshold value : ");
        double threshold = sc.nextDouble();

        // Create a list to store sensor readings
        List<Double> readings = new ArrayList<>();

        System.out.println("Enter sensor readings : ");
        for (int i = 0; i < n; i++) {
            readings.add(sc.nextDouble());
        }

        System.out.println("\nReadings above threshold:");
        readings.stream()
                .filter(r -> r > threshold) 
                .forEach(r -> System.out.println("Reading : " + r));
	}
}
