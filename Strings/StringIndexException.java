import java.util.Scanner;

public class StringIndexException {

    public static void generateException(String input) {
        char ch = input.charAt(input.length()); 
        System.out.println("Character at invalid index: " + ch);
    }

    public static void handleException(String input) {
        try {
            char ch = input.charAt(input.length()); 
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException : Invalid index access!");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO Auto-generated method stub
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        try {
            generateException(userInput);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception in generateException() : " + e);
        }
        handleException(userInput);
    }
}
