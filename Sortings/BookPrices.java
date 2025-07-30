import java.util.Scanner;

public class BookPrices {
	
	//Method to merge two halves
	public static void merge(double[] prices, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;
		
		//Temporary Arrays
		double[] L = new double[n1];
		double[] R = new double[n2];
		
		//Copy data to temporary arrays
		for(int i = 0; i < n1; i++) {
			L[i] = prices[left + i];
		}
		for(int j = 0; j < n2; j++) {
			R[j] = prices[mid + 1 + j];
		}
		
		//Merger the temporary arrays
		int i = 0, j = 0, k = left;
		while(i < n1 && j < n2) {
			if(L[i] <= R[j]) {
				prices[k] = L[i];
				i++;
			} else {
				prices[k] = R[j];
				j++;
			}
			k++;
		}
		
		//Copy remaining elements of L[]
		while(i < n1) {
			prices[k] = L[i];
			i++;
			k++;
		}
		//Copy remaining elements of R[]
		while(j < n2) {
			prices[k] = R[j];
			j++;
			k++;
		}
	}
	
	//Method to perform merge sort
	public static void mergeSort(double[] prices, int left, int right) {
		if(left < right) {
			int mid = left + (right - left) / 2;
			
			mergeSort(prices, left, mid);
			mergeSort(prices, mid + 1, right);
			
			merge(prices, left, mid, right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of books : ");
		int n = sc.nextInt();
		
		double[] prices = new double[n];
		
		System.out.println("Enter the prices of books : ");
		for(int i = 0; i < n; i++) {
			System.out.print("Book " + (i + 1) + " : Rs.");
			prices[i] = sc.nextDouble();
		}
		
		mergeSort(prices, 0, n - 1);
		
		//Display sorted prices
		System.out.println("\nSorted Book Prices in Ascending Order : ");
		for(double price : prices) {
			System.out.printf("Rs.%.2f\n", price);
		}
		
	}
}
