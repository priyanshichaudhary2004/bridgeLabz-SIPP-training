import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class UpperCaseToLowerCase {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        String inputFile = "input.txt";    
        String outputFile = "output.txt";  

        try (
            // FileReader and BufferedReader to read text
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));

            // FileWriter and BufferedWriter to write text
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase()); 
                writer.newLine();             
            }

            System.out.println("Conversion complete. Output written to " + outputFile);
        } catch (IOException e) {
            System.out.println("IOException : " + e.getMessage());
        }
    }
}
