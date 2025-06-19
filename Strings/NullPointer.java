public class NullPointer {

    public static void generateException() {
        String text = null; 
        int length = text.length(); 
        System.out.println("Length of string : " + length);
    }

    public static void handleException() {
        String text = null; 
        try {
            int length = text.length(); 
            System.out.println("Length of string : " + length);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException : Cannot call method on a null object!");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Exception in generateException() : " + e);
        }
        handleException();
    }
}
