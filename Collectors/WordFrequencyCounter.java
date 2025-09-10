import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Map;

public class WordFrequencyCounter {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter a paragraph : ");
        String paragraph = sc.nextLine();

        String[] words = paragraph.toLowerCase()
                                  .replaceAll("[^a-zA-Z0-9\\s]", "")
                                  .split("\\s+");

        Map<String, Integer> wordCount =
            Arrays.stream(words)   
                  .collect(Collectors.toMap(
                      word -> word,   
                      word -> 1,      
                      Integer::sum    
                  ));

        System.out.println("\nWord Frequency : ");
        wordCount.forEach((word, count) -> 
            System.out.println(word + " -> " + count));
    }
}