import java.util.Scanner;
public class PositiveNegativeAndZeroNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.print("Enter a number : ");
		num = sc.nextInt();
		
		int result = checkNumber(num);
		if(result == 1) {
			System.out.println("The number is positive.");
		} else if(result == -1) {
			System.out.println("The number is negative.");
		} else {
			System.out.println("The number is zero.");
		}
	}
	
	public static int checkNumber(int number) {
		if(number > 0) {
			return 1;
		} else if (number < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
