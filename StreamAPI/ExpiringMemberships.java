import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpiringMemberships {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        List<Member> members = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Enter number of members : ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter member name : ");
            String memName = sc.nextLine();
            System.out.print("Enter membership expiry date (yyyy-MM-dd) : ");
            String dateStr = sc.nextLine();
            LocalDate expiryDate = LocalDate.parse(dateStr, formatter);
            members.add(new Member(memName, expiryDate));
        }

        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);

        System.out.println("\nMembers whose membership expires within 30 days : ");
        members.stream()
                .filter(m -> !m.getExpiryDate().isBefore(today) && !m.getExpiryDate().isAfter(thirtyDaysLater))
                .forEach(System.out::println);
	}
}
