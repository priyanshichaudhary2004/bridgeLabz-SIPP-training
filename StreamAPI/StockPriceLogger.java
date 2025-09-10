import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockPriceLogger {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stock prices : ");
        int n = sc.nextInt();

        // Create a list to store stock prices
        List<Double> stockPrices = new ArrayList<>();

        System.out.println("Enter stock prices : ");
        for (int i = 0; i < n; i++) {
            stockPrices.add(sc.nextDouble());
        }

        System.out.println("\nStock Price Updates : ");
        stockPrices.stream()
                   .forEach(price -> System.out.println("Stock Price : $" + price));
	}
}
