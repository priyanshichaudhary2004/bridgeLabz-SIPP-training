import java.util.Scanner;

public class CharacterComparasion {
	public static char[] getCharacters(String str) {
		char[] result = new char[str.length()];
		for(int i = 0; i < str.length(); i++) {
			result[i] = str.charAt(i);
		}
		return result;
	}
	
	public static boolean compareArray(char[] arr1, char[] arr2) {
		if (arr1.length != arr2.length) {
			return false;
		}
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a string : ");
        String input = sc.next();
        
        char[] userDefinedChars = getCharacters(input);
        char[] builtInChars = input.toCharArray();
        
        boolean areEqual = compareArray(userDefinedChars, builtInChars);
        
        System.out.println("User-defined character array : ");
        for (char c : userDefinedChars) {
            System.out.print(c + " ");
        }

        System.out.println("\nBuilt-in toCharArray result : ");
        for (char c : builtInChars) {
            System.out.print(c + " ");
        }
        System.out.println("\nAre both arrays equal? " + areEqual);
	}
}
