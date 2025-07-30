import java.util.Scanner;

public class StudentMarks {
	
	//Method to perform Bubble sort on the array
	public static void bubbleSort(int[] marks) {
		int n = marks.length;
		boolean swapped;
		
		//Loop for traversing the array
		for(int i = 0; i < n - 1; i++) {
			swapped = false;
			
			//Loop for comparing adjacent elements
			for(int j = 0; j < n - i - 1; j++) {
				if(marks[j] > marks[j + 1]) {
					//Swap if current is greater than next
					int temp = marks[j];
					marks[j] = marks[j + 1];
					marks[j + 1] = temp;
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of students : ");
		int n = sc.nextInt();
		
		int[] marks = new int[n];
		
		System.out.println("Enter the marks of " + n + " students : ");
		for(int i = 0; i < n; i++) {
			System.out.print("Student " + (i + 1) + " : ");
			marks[i] = sc.nextInt();
		}
		
		//Sort the marks using bubble sort
		bubbleSort(marks);
		
		//Display sorted marks
		System.out.println("\nSorted Marks in Ascending Order : ");
		for(int mark : marks) {
			System.out.println(mark);
		}
	}
}
