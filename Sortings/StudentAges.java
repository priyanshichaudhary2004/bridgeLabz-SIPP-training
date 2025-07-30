import java.util.Scanner;

public class StudentAges {
	
	//Method to perform Counting Sort
	public static void countingSort(int[] ages) {
		int minAge = 10;
		int maxAge = 18;
		int range = maxAge - minAge + 1;
		
		int[] count = new int[range];
		int[] output = new int[ages.length];
		
		//Count the occurrences of each age
		for(int age : ages) {
			count[age - minAge]++;
		}
		
		//Compute cumulative frequencies
		for(int i = 1; i < range; i++) {
			count[i] += count[i - 1];
		}
		
		//Build the output array
		for(int i = ages.length - 1; i >= 0; i--) {
			int age = ages[i];
			output[count[age - minAge] - 1] = age;
			count[age - minAge]--;
		}
		
		//Copy sorted ages back into original array
		for(int i = 0; i < ages.length; i++) {
			ages[i] = output[i];
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of students : ");
		int n = sc.nextInt();
		
		int[] ages = new int[n];
		
		System.out.println("Enter ages of students : ");
		for(int i = 0; i < n; i++) {
			System.out.print("Student " + (i + 1) + " : ");
			int age = sc.nextInt();
			
			while(age < 10 || age > 18) {
				System.out.print("Invalid age!");
				age = sc.nextInt();
			}
			ages[i] = age;
		}
		
		countingSort(ages);
		
		System.out.println("\nSorted Student Ages in Ascending Order : ");
		for(int age : ages) {
			System.out.println(age);
		}
	}
}
