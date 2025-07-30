import java.util.Scanner;
import java.util.Stack;

public class SortStackRecursively {
	Stack<Integer> stack;
	
	//Constructor
	SortStackRecursively() {
		stack = new Stack<>();
	}
	
	//Method to insert element in sorted order
	void sortedInsert(int element) {
		if(stack.isEmpty() || element > stack.peek()) {
			stack.push(element);
			return;
		}
		int top = stack.pop();
		sortedInsert(element);
		stack.push(top);
	}
	
	//Recursive Method to sort the stack
	void sortStack() {
		if(!stack.isEmpty()) {
			int top = stack.pop();
			sortStack();
			sortedInsert(top);
		}
	}
	
	//Method to print stack
	void printStack() {
		System.out.println("Stack : ");
		for(int i = stack.size() - 1; i >= 0; i--) {
			System.out.println(stack.get(i));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SortStackRecursively sortStack = new SortStackRecursively();
		
		System.out.print("Enter the number of elements in stack : ");
		int n = sc.nextInt();
		
		System.out.println("Enter " + n + " elements : ");
		for(int i = 0; i < n; i++) {
			int val = sc.nextInt();
			sortStack.stack.push(val);
		}
		
		System.out.println("\nOriginal Stack : ");
		sortStack.printStack();
		
		sortStack.sortStack();
		
		System.out.println("\nSorted Stack : ");
		sortStack.printStack();
	}
}
