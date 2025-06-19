import java.util.Scanner;

public class WordSplittingIn2D {
    public static String[] splitIntoWords(String text) {
        String[] words = new String[100];
        int wordIndex = 0;
        String currentWord = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                currentWord += ch;
            } else {
                if (!currentWord.equals("")) {
                    words[wordIndex++] = currentWord;
                    currentWord = "";
                }
            }
        }
        if (!currentWord.equals("")) {
            words[wordIndex++] = currentWord;
        }
        String[] finalWords = new String[wordIndex];
        for (int i = 0; i < wordIndex; i++) {
            finalWords[i] = words[i];
        }
        return finalWords;
    }

    public static int findLength(String word) {
        int count = 0;
        try {
            while (true) {
                word.charAt(count);
                count++;
            }
        } catch (Exception e) {
            
        }
        return count;
    }

    public static String[][] getWordLengthArray(String[] words) {
        String[][] wordLengthArray = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            wordLengthArray[i][0] = words[i];
            wordLengthArray[i][1] = String.valueOf(findLength(words[i]));
        }
        return wordLengthArray;
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a sentence : ");
        String input = sc.nextLine();

        String[] words = splitIntoWords(input);
        String[][] result = getWordLengthArray(words);

        System.out.println("\nWord\tLength");
        for (int i = 0; i < result.length; i++) {
            int length = Integer.parseInt(result[i][1]); 
            System.out.println(result[i][0] + "\t" + length);
        }
    }
}
