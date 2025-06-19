import java.util.Scanner;

public class WordsSplitingChecker {
    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {

        }
        return count;
    }

    public static String[] customSplit(String text) {
        int len = getLength(text);

        int wordCount = 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        int[] spaceIndexes = new int[wordCount + 1]; 
        int index = 0;
        spaceIndexes[index++] = -1; 
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }
        spaceIndexes[index] = len;
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            int start = spaceIndexes[i] + 1;
            int end = spaceIndexes[i + 1];
            String word = "";
            for (int j = start; j < end; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
        }
        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
        	return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
            	return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a line of text : ");
        
        String input = sc.nextLine();

        String[] builtInSplit = input.split(" ");
        String[] customSplit = customSplit(input);

        System.out.println("\nBuilt-in split() : ");
        for (String word : builtInSplit) {
            System.out.println(word);
        }

        System.out.println("\nCustom split() : ");
        for (String word : customSplit) {
            System.out.println(word);
        }

        boolean areEqual = compareArrays(builtInSplit, customSplit);
        System.out.println("\nAre both arrays equal? " + areEqual);
    }
}
