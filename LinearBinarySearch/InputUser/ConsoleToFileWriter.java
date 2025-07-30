import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class ConsoleToFileWriter {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        System.out.println("Enter text to write to the file (type 'exit' to stop) : ");

        try (
            InputStreamReader isr = new InputStreamReader(System.in); // 1. Read from console
            BufferedReader reader = new BufferedReader(isr); // 2. Buffered for efficiency
            FileWriter fw = new FileWriter("output.txt"); // 3. Write to file
            BufferedWriter writer = new BufferedWriter(fw); // BufferedWriter for efficiency
        ) {
            String inputLine;
            while (true) {
                inputLine = reader.readLine(); 
                if ("exit".equalsIgnoreCase(inputLine)) {
                    break; 
                }
                writer.write(inputLine); 
                writer.newLine(); 
            }
            System.out.println("Input saved to output.txt");

        } catch (IOException e) {
            System.out.println("An error occurred while reading input or writing to file.");
            e.printStackTrace();
        }
    }
}
