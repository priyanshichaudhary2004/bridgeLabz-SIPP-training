import java.util.Scanner;
import java.util.HashSet;

public class RemoveDuplicatesUsingStringBuilder {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string : ");
		String str = sc.nextLine();
		
		StringBuilder sb = new StringBuilder(str.length());
		HashSet<Character> seen = new HashSet<>();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(!seen.contains(c)) {
				sb.append(c);
				seen.add(c);
			}
		}
		System.out.println("String without duplicates : " + sb.toString());
	}

}
