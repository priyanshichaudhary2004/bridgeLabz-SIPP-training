import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoggingTransaction {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of transactions : ");
        int n = sc.nextInt();
        sc.nextLine(); 

        List<String> transactionIds = new ArrayList<>();

        System.out.println("Enter " + n + " transaction IDs : ");
        for (int i = 0; i < n; i++) {
            transactionIds.add(sc.nextLine());
        }

        transactionIds.stream()
            .forEach(id -> System.out.println(LocalDateTime.now() + " - Transaction : " + id));
	}
}
