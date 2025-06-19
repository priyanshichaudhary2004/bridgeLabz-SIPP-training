import java.util.Scanner;
public class CharactersAtLowerCase {
	public static String toLowerCase(String input) {
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if(ch >= 'A' && ch <= 'Z') {
				ch = (char)(ch + 32);
			}
			result.append(ch);
		}
		return result.toString();
	}
	
	public static boolean compareString(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		for(int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i) != str2.charAt(i)) {
				return false;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a sentence : ");
        String input = sc.nextLine();
        
        String builtinLower = input.toLowerCase();
        String customLower = toLowerCase(input);
        boolean isSame = compareString(builtinLower, customLower);
        
        System.out.println("Original Input      : " + input);
        System.out.println("Built-in Lowercase  : " + builtinLower);
        System.out.println("Custom Lowercase    : " + customLower);
        System.out.println("Are both same?      : " + isSame);
	}

}
