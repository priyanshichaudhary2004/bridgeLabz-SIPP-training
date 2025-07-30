import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class ComparisonChallenge {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        compareStringBuilderAndBuffer();
        readFileAndCountWords();
    }

    public static void compareStringBuilderAndBuffer() {
        String str = "hello";
        int repetitions = 1_000_000;

        // StringBuilder
        long startBuilder = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repetitions; i++) {
            sb.append(str);
        }
        long endBuilder = System.currentTimeMillis();
        System.out.println("StringBuilder Time : " + (endBuilder - startBuilder) + " ms");

        // StringBuffer
        long startBuffer = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < repetitions; i++) {
            sbuf.append(str);
        }
        long endBuffer = System.currentTimeMillis();
        System.out.println("StringBuffer Time : " + (endBuffer - startBuffer) + " ms");
    }

    //Read file using FileReader and InputStreamReader and count words
    public static void readFileAndCountWords() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the path of the large text file : ");
        String filePath = sc.nextLine();

        // --- FileReader approach ---
        try (
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr)
        ) {
            long start = System.currentTimeMillis();
            int wordCount = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                wordCount += (line.isEmpty()) ? 0 : words.length;
            }
            long end = System.currentTimeMillis();
            System.out.println("[FileReader] Word Count : " + wordCount);
            System.out.println("[FileReader] Time : " + (end - start) + " ms");
        } catch (IOException e) {
            System.out.println("Error reading file with FileReader.");
        }

        // --- InputStreamReader approach ---
        try (
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr)
        ) {
            long start = System.currentTimeMillis();
            int wordCount = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                wordCount += (line.isEmpty()) ? 0 : words.length;
            }
            long end = System.currentTimeMillis();
            System.out.println("[InputStreamReader] Word Count : " + wordCount);
            System.out.println("[InputStreamReader] Time : " + (end - start) + " ms");
        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader.");
        }
    }
}
