import java.util.Scanner;
public class ArrayIndexException {
	public static void generateException(String[] names) {
		System.out.print("Accessing names[5] which does not exist : " + names[5]);
	}
	
	public static void handleException(String[] names) {
		try {
			System.out.print("Accessing names[5] which does not exist : " + names[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.print("Caught ArrayIndexOutOfBoundsException : " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.print("Caught RuntimeException : " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of names : ");
		int n = sc.nextInt();
		sc.nextLine();
		
		String[] names = new String[n];
		System.out.println("Enter " + n + " names : ");
		for(int i = 0; i < n; i++) {
			names[i] = sc.nextLine();
		}
		try {
			generateException(names);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception generated and not handled in method : " + e.getMessage());
		}
		handleException(names);
	}
}
