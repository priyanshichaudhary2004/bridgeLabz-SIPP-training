import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadLineByLine {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter path to the large log/text file : ");
        String filePath = sc.nextLine();

        // BufferedReader for efficient line-by-line reading
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println("Line " + lineNumber + " : " + line);
                    found = true;
                }
                lineNumber++;
            }

            if (!found) {
                System.out.println("No lines containing the word 'error' found in the file.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException while reading file : " + e.getMessage());
        }
    }
}
