import java.util.Scanner;

public class ShortestAndLongestString {
    public static String[] splitWords(String text) {
        String[] words = new String[100]; 
        int index = 0;
        String word = "";

        for (int i = 0;; i++) {
            try {
                char ch = text.charAt(i);
                if (ch != ' ') {
                    word += ch;
                } else {
                    if (!word.equals("")) {
                        words[index++] = word;
                        word = "";
                    }
                }
            } catch (Exception e) {
                if (!word.equals("")) {
                    words[index++] = word;
                }
                break;
            }
        }
        String[] result = new String[index];
        for (int i = 0; i < index; i++) {
            result[i] = words[i];
        }
        return result;
    }

    public static int getLength(String word) {
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

    public static String[][] wordWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestAndLongest(String[][] wordData) {
        int minIndex = 0, maxIndex = 0;
        int minLength = Integer.parseInt(wordData[0][1]);
        int maxLength = Integer.parseInt(wordData[0][1]);

        for (int i = 1; i < wordData.length; i++) {
            int length = Integer.parseInt(wordData[i][1]);
            if (length < minLength) {
                minLength = length;
                minIndex = i;
            }
            if (length > maxLength) {
                maxLength = length;
                maxIndex = i;
            }
        }
        return new int[] { minIndex, maxIndex };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence : ");
        String input = sc.nextLine();

        String[] words = splitWords(input);
        String[][] wordData = wordWithLengths(words);
        int[] shortestAndLongest = findShortestAndLongest(wordData);

        System.out.println("\nWord\t\tLength");
        for (int i = 0; i < wordData.length; i++) {
            System.out.println(wordData[i][0] + "\t\t" + wordData[i][1]);
        }

        System.out.println("\nShortest word : " + wordData[shortestAndLongest[0]][0]);
        System.out.println("Longest word : " + wordData[shortestAndLongest[1]][0]);
    }
}
