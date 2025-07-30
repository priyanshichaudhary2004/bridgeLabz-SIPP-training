import java.util.Scanner;

public class EmployeeID {

	//Method to perform Insertion Sort
	public static void insertionSort(int[] ID) {
		int n = ID.length;
		
		for(int i = 1; i < n; i++) {
			int key = ID[i];
			int j = i - 1;
			
			//Shift elements of the sorted part that are greater than key
			while(j >= 0 && ID[j] > key ) {
				ID[j + 1] = ID[j];
				j--;
			}
			
			//Insert the key at the correct position
			ID[j + 1] = key;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of employees : ");
		int n = sc.nextInt();
		
		int[] ID = new int[n];
		
		System.out.println("Enter the Employee IDs : ");
		for(int i = 0; i < n; i++) {
			System.out.print("Employee " + (i + 1) + " IDs : ");
			ID[i] = sc.nextInt();
		}
		
		insertionSort(ID);
		
		//Sorted ID
		System.out.println("\nSorted Employee IDs in Ascending Order : ");
		for(int id : ID) {
			System.out.println(id);
		}
	}
}
