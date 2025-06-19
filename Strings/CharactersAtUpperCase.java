import java.util.Scanner;

public class CharactersAtUpperCase {
    public static String convertToUpperCase(String input) {
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char)(ch - 32); 
            } else {
                result += ch;
            }
        }

        return result;
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	Scanner sc = new Scanner(System.in);
    	
        System.out.print("Enter a line of text : ");
        String original = sc.nextLine();

        String customUpper = convertToUpperCase(original);
        String builtInUpper = original.toUpperCase();

        boolean isEqual = compareStrings(customUpper, builtInUpper);

        System.out.println("\nCustom Uppercase Conversion : " + customUpper);
        System.out.println("Built-in toUpperCase() : " + builtInUpper);
        System.out.println("Are both conversions equal? " + isEqual);
    }
}
