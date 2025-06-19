import java.util.Scanner;

public class LengthOfString {
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count); 
                count++;
            }
        } catch (Exception e) {
            
        }
        return count;
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string : ");
        String input = sc.next(); 

        int manualLength = findLength(input);
        int builtinLength = input.length();

        System.out.println("\nLength calculated without using length() : " + manualLength);
        System.out.println("Length using built-in length() : " + builtinLength);
    }
}
