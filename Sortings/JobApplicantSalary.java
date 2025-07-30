import java.util.Scanner;

public class JobApplicantSalary {
	
	//Method to heapify a subtree rooted at index i (max heap)
	public static void heapify(int[] salaries, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		//If left child is larger than root
		if(left < n && salaries[left] > salaries[largest]) {
			largest = left;
		}
		
		//If right child is larger than current largest
		if(right < n && salaries[right] > salaries[largest]) {
			largest = right;
		}
		
		//If largest is not root
		if(largest != i) {
			int temp = salaries[i];
			salaries[i] = salaries[largest];
			salaries[largest] = temp;
			
			//Recursively heapify the affected sub-tree
			heapify(salaries, n, largest);
		}
	}
	
	public static void heapSort(int[] salaries) {
		int n = salaries.length;
		
		//Build a max heap
		for(int i = n / 2 - 1; i >= 0; i--) {
			heapify(salaries, n, i);
		}
		
		//One by one extract elements from heap
		for(int i = n - 1; i >= 0; i--) {
			int temp = salaries[0];
			salaries[0] = salaries[i];
			salaries[i] = temp;
			
			heapify(salaries, i, 0);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of job applicants : ");
		int n = sc.nextInt();
		
		int[] salaries = new int[n];
		
		System.out.println("Enter the expected salaries : ");
		for(int i = 0; i < n; i++) {
			System.out.print("Applicant " + (i + 1) + " : Rs.");
			salaries[i] = sc.nextInt();
		}
		
		heapSort(salaries);
		
		//Display sorted salaries
		System.out.println("\nSorted Expected Salaries in Ascending Order : ");
		for(int salary : salaries) {
			System.out.println("Rs." + salary);
		}
	}
}
