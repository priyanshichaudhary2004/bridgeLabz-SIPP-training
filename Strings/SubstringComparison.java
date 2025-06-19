import java.util.Scanner;

public class SubstringComparison {
    public static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string : ");
        String text = sc.next();

        System.out.print("Enter start index : ");
        int start = sc.nextInt();

        System.out.print("Enter end index : ");
        int end = sc.nextInt();

        String customSub = customSubstring(text, start, end);
        String builtInSub = text.substring(start, end);

        boolean isEqual = compareStrings(customSub, builtInSub);

        System.out.println("Custom Substring using charAt() : " + customSub);
        System.out.println("Built-in Substring : " + builtInSub);
        System.out.println("Are both substrings equal? " + isEqual);
    }
}
