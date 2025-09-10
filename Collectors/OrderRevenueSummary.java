import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class OrderRevenueSummary {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        List<Order> orders = new ArrayList<>();

        System.out.print("Enter number of orders : ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter customer name : ");
            String name = sc.nextLine();

            System.out.print("Enter order amount : ");
            double amount = sc.nextDouble();
            sc.nextLine(); 

            orders.add(new Order(name, amount));
        }

        Map<String, Double> revenueSummary = orders.stream()
            .collect(Collectors.groupingBy(
                Order::getCustomer,
                Collectors.summingDouble(Order::getAmount)
            ));

        System.out.println("\n--- Order Revenue Summary ---");
        revenueSummary.forEach((customer, total) -> 
            System.out.println(customer + " -> " + total)
        );
    }
}