import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordCounter {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter the path of the file to read : ");
        String filePath = sc.nextLine();

        System.out.print("Enter the word to count : ");
        String targetWord = sc.nextLine().toLowerCase(); 

        int count = 0; 

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                
                String[] words = line.toLowerCase().split("\\W+"); // \W+ = split by non-word characters
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++; 
                    }
                }
            }
            System.out.println("The word \"" + targetWord + "\" appears " + count + " times in the file.");

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
	}
}
