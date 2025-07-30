import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.util.Scanner;

public class ByteToCharReader {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the path of the file to read (UTF-8 encoded) : ");
        String filePath = sc.nextLine();

        try (
            FileInputStream fis = new FileInputStream(filePath); 
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8"); 
            BufferedReader reader = new BufferedReader(isr) 
        ) {
            String line;
            System.out.println("\n--- File Content ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print each line
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check the path.");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding. Make sure to use a valid charset like UTF-8.");
        } catch (IOException e) {
            System.out.println("I/O error occurred while reading the file.");
        }
    }
}
