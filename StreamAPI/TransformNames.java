import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransformNames {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        List<String> customers = new ArrayList<>();

        System.out.print("Enter number of customers : ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter customer name : ");
            String name = sc.nextLine();
            customers.add(name);
        }

        System.out.println("\nCustomer names in uppercase and sorted alphabetically : ");
        customers.stream()
                 .map(String::toUpperCase)   
                 .sorted()                   
                 .forEach(System.out::println);
	}
}
