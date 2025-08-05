import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReadingComparison {

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        //User input for file path
        System.out.print("Enter file path (e.g. C:/largefile.txt) : ");
        String filePath = sc.nextLine();

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File does not exist. Please check the path.");
            return;
        }

        System.out.println("\n--- File Reading Performance Comparison ---");

        //FileReader Test (Character Stream)
        try (FileReader fr = new FileReader(file)) {
            long startFR = System.nanoTime();
            while (fr.read() != -1) {
                // reading character by character (slow)
            }
            long endFR = System.nanoTime();
            System.out.println("FileReader (char stream) : " + formatTime(endFR - startFR));
        } catch (IOException e) {
            System.out.println("FileReader error : " + e.getMessage());
        }

        //InputStreamReader Test (Byte Stream)
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file))) {
            long startISR = System.nanoTime();
            while (isr.read() != -1) {
                // reading byte by byte, converting to char (faster)
            }
            long endISR = System.nanoTime();
            System.out.println("InputStreamReader (byte stream) : " + formatTime(endISR - startISR));
        } catch (IOException e) {
            System.out.println("InputStreamReader error : " + e.getMessage());
        }

        System.out.println("\nInputStreamReader is more efficient for large files.");
        System.out.println("FileReader is better for simple character-based reading.");
    }

    // Converts nanoseconds to readable format
    private static String formatTime(long nanos) {
        long millis = nanos / 1_000_000;
        if (millis < 1000) {
        	return millis + " ms";
        }
        double seconds = millis / 1000.0;
        return String.format("%.2f s", seconds);
    }
}
