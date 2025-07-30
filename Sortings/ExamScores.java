import java.util.Scanner;

public class ExamScores {
	
	//Method to perform Selection Sort
	public static void selectionSort(int[] scores) {
		int n = scores.length;
		
		for(int i = 0; i < n - 1; i++) {
			int minIndex = i;
			
			//Find the index of the minimum element
			for(int j = i + 1; j < n; j++) {
				if(scores[j] < scores[minIndex]) {
					minIndex = j;
				}
			}
			
			int temp = scores[minIndex];
			scores[minIndex] = scores[i];
			scores[i] = temp;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of Students : ");
		int n = sc.nextInt();
		
		int[] scores = new int[n];
		
		System.out.println("Enter the exam scores of students : ");
		for(int i = 0; i < n; i++) {
			System.out.print("Student " + (i + 1) + " : ");
			scores[i] = sc.nextInt();
		}
		
		selectionSort(scores);
		
		System.out.println("\nSorted Exam Scores in Ascending Order : ");
		for(int score : scores) {
			System.out.println(score);
		}
	}
}
