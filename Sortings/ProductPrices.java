import java.util.Scanner;

public class ProductPrices {
	
	//Method to partition the array
	public static int partition(double[] prices, int low, int high) {
		double pivot = prices[high]; //Using last element as pivot
		int i = low - 1;
		
		for(int j = low; j < high; j++) {
			if(prices[j] <= pivot) {
				i++;
				double temp = prices[i];
				prices[i] = prices[j];
				prices[j] = temp;
			}
		}
		
		//Swap pivot to the correct position
		double temp = prices[i + 1];
		prices[i + 1] = prices[high];
		prices[high] = temp;
		
		return i + 1;
	}
	
	//Quick Sort Function
	public static void quickSort(double[] prices, int low, int high) {
		if(low < high) {
			int pivotIndex = partition(prices, low, high);
			quickSort(prices, low, pivotIndex - 1);
			quickSort(prices, pivotIndex + 1, high);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of products : ");
		int n =sc.nextInt();
		
		double[] prices = new double[n];
		
		System.out.println("Enter the prices of products : ");
		for(int i = 0; i < n; i++) {
			System.out.print("Product " + (i + 1) + " : Rs.");
			prices[i] = sc.nextDouble();
		}
		
		quickSort(prices, 0, n - 1);
		
		System.out.println("\nSorted Product Prices in Ascending Order : ");
		for(double price : prices) {
			System.out.printf("Rs.%2f\n", price);
		}
	}
}
