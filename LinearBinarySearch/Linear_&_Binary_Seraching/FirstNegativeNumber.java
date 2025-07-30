import java.util.Scanner;
public class FirstNegativeNumber {
	
	public static int findFirstNegativeIndex(int[] arr) {
        // Linear search: Return early if negative number is found
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i; 
            }
        }
        return -1; 
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integer elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int index = findFirstNegativeIndex(arr);

        if (index != -1) {
            System.out.println("First negative number found at index : " + index);
        } else {
            System.out.println("No negative number found in the array.");
        }
	}
}
