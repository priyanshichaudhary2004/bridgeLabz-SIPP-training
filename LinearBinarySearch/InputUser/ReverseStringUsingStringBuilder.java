import java.util.Scanner;

public class ReverseStringUsingStringBuilder {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string : ");
		String str = sc.nextLine();
		
		StringBuilder sb = new StringBuilder(str.length());
		
		//Append input string to stringbuilder
		sb.append(str);
		
		sb.reverse();
		
		String reversed = sb.toString();
		System.out.println("Reversed String : " + reversed);
	}
}
