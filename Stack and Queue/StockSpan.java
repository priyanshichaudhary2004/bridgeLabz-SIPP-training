import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
	//Function to calculate stock span
	static int[] calculateSpan(int[] prices) {
		int n = prices.length;
		int[] span = new int[n];
		Stack<Integer> stack = new Stack<>();
		
		//Traverse all days
		for(int i = 0; i < n; i++) {
			while(!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
				stack.pop();
			}
			
			span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
			stack.push(i);
 		}
		return span;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of days : ");
		int n = sc.nextInt();
		
		int[] prices = new int[n];
		System.out.println("Enter stock prices for " + n + " days : ");
		for(int i = 0; i < n; i++) {
			prices[i] = sc.nextInt();
		}
		
		int[] span = calculateSpan(prices);
		
		System.out.println("Stock span for each day : ");
		for(int i = 0; i < n; i++) {
			System.out.println("Day " + (i + 1) + " : " + span[i]);
		}
	}
}
