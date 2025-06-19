import java.util.Scanner;
public class Handshakes {
	public static int calculateHandshakes (int num) {
		return (num * (num - 1)) / 2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.print("Enter the number of students : ");
		num = sc.nextInt();
		
		int handshakes = calculateHandshakes(num);
		System.out.println("The maximum number of possible handshakes : " + handshakes);

	}

}
