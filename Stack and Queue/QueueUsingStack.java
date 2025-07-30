import java.util.Scanner;
import java.util.Stack;

//Class to implement queue using two stacks
class QueueUsingTwoStacks {
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	
	//Constructor
	QueueUsingTwoStacks() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}
	
	//Enqueue operation
	public void enqueue(int data) {
		stack1.push(data);
	}
	
	//Dequeue operation
	public int dequeue() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is Empty!");
		}
		
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
	
	//Peek from element
	public int peek() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is Empty!");
		} 
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}
	
	//Check if queue is empty
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
}

public class QueueUsingStack {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        int choice;

        System.out.println("Queue Implementation Using Two Stacks");

        do {
            System.out.println("\nMenu :");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek (Front)");
            System.out.println("4. Check if Empty");
            System.out.println("5. Exit");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue : ");
                    int val = sc.nextInt();
                    queue.enqueue(val);
                    System.out.println(val + " enqueued.");
                    break;
                case 2:
                    try {
                        int removed = queue.dequeue();
                        System.out.println("Dequeued : " + removed);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        int front = queue.peek();
                        System.out.println("Front element : " + front);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println(queue.isEmpty() ? "Queue is empty." : "Queue is not empty.");
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
	}

}
