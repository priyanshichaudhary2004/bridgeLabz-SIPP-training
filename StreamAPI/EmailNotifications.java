import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmailNotifications {
	
	// Dummy method to simulate sending an email
    public static void sendEmailNotification(String email) {
        System.out.println("Notification sent to : " + email);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of users : ");
        int n = sc.nextInt();
        sc.nextLine(); 

        List<String> emails = new ArrayList<>();

        System.out.println("Enter " + n + " email addresses : ");
        for (int i = 0; i < n; i++) {
            emails.add(sc.nextLine());
        }

        emails.stream()
              .forEach(email -> sendEmailNotification(email));
	}
}
