import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HospitalDoctorAvailability {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        List<Doctor> doctors = new ArrayList<>();

        System.out.print("Enter number of doctors : ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter doctor name : ");
            String name = sc.nextLine();
            System.out.print("Enter specialty : ");
            String specialty = sc.nextLine();
            System.out.print("Available on weekend (true/false) : ");
            boolean weekend = sc.nextBoolean();
            sc.nextLine(); 
            doctors.add(new Doctor(name, specialty, weekend));
        }

        System.out.println("\nDoctors available on weekends (sorted by specialty) : ");
        doctors.stream()
                .filter(Doctor::isAvailableOnWeekend)
                .sorted(Comparator.comparing(Doctor::getSpecialty))
                .forEach(System.out::println);
	}
}
