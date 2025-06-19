import java.util.Scanner;

public class StringComparasionUsingTrim {

    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = 0;

        try {
            while (true) {
                if (text.charAt(start) != ' ') break;
                start++;
            }
        } catch (Exception e) {
            return new int[]{0, 0}; 
        }

        try {
            end = 0;
            while (true) {
                text.charAt(end); 
                end++;
            }
        } catch (Exception e) {
            end--; 
        }

        while (end >= 0 && text.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }

    public static String customSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static boolean customCompare(String s1, String s2) {
        try {
            int i = 0;
            while (true) {
                if (s1.charAt(i) != s2.charAt(i)) return false;
                i++;
            }
        } catch (Exception e) {
            
        }

        try {
            s1.charAt(s2.length()); 
            s2.charAt(s1.length()); 
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string with leading and trailing spaces : ");
        String input = sc.nextLine();

        int[] indexes = findTrimIndexes(input);
        String customTrimmed = customSubstring(input, indexes[0], indexes[1]);
        String builtinTrimmed = input.trim();

        System.out.println("\nCustom Trimmed : [" + customTrimmed + "]");
        System.out.println("Built-in Trimmed : [" + builtinTrimmed + "]");

        boolean isSame = customCompare(customTrimmed, builtinTrimmed);
        System.out.println("\nAre both trimmed strings equal? " + isSame);
    }
}
