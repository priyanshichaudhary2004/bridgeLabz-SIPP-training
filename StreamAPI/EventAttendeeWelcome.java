import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventAttendeeWelcome {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of attendees : ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Create a list to store attendee names
        List<String> attendees = new ArrayList<>();

        System.out.println("Enter attendee names : ");
        for (int i = 0; i < n; i++) {
            attendees.add(sc.nextLine());
        }

        System.out.println("\nWelcome Messages : ");
        attendees.stream()
                 .forEach(name -> System.out.println("Welcome, " + name + "!"));
	}
}
