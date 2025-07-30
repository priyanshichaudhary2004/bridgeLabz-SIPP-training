import java.util.Scanner;

public class ConcatenateStringUsingStringBuffer {
	
	public static String concatenateString(String[] strings) {
		StringBuffer sb = new StringBuffer();
		
		//Append each string to the buffer
		for(String str : strings) {
			sb.append(str);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = 0;

        while (true) {
            System.out.print("Enter number of strings : ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine(); 
                break;
            } else {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); 
            }
        }
		
		//Create array to store user input
		String[] inputStrings = new String[n];
		
		for(int i = 0; i < n; i++) {
			System.out.print("Enter string " + (i + 1) + " : ");
			inputStrings[i] = sc.nextLine();
		}
		
		//Call method
		String result = concatenateString(inputStrings);
		
		System.out.println("Concatenate String : " + result);
	}
}
