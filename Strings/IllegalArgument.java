import java.util.Scanner;

public class IllegalArgument {

    public static void generateException(String str) {
        String error = str.substring(5, 2); 
        System.out.println("Generated substring: " + error); 
    }

    public static void handleException(String str) {
        try {
            String error = str.substring(5, 2); 
            System.out.println("Generated substring : " + error);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException : " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string : ");
        String input = sc.next();
        System.out.println("\nGenerating Exception (no handling)");
        try {
            generateException(input);  
        } catch (Exception e) {
            System.out.println("Exception thrown in generateException() : " + e.getClass().getSimpleName());
        }

        System.out.println("\nHandling Exception");
        handleException(input);
    }
}
