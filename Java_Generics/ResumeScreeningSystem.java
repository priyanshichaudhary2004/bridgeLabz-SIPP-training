import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResumeScreeningSystem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<JobRole> jobRoles = new ArrayList<>();

        System.out.print("Enter number of resumes to process : ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details for Resume " + i);
            System.out.print("Enter job role (SE/DS/PM) : ");
            String role = sc.nextLine();

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter years of experience : ");
            int exp = Integer.parseInt(sc.nextLine());

            switch (role.toUpperCase()) {
                case "SE":
                    jobRoles.add(new SoftwareEngineer(name, exp));
                    break;
                case "DS":
                    jobRoles.add(new DataScientist(name, exp));
                    break;
                case "PM":
                    jobRoles.add(new ProductManager(name, exp));
                    break;
                default:
                    System.out.println("Invalid role.");
            }
        }
        // Process all job roles using wildcard method
        ResumeProcessor.processResumes(jobRoles);
	}
}
