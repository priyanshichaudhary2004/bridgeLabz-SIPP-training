public class NumberCheckerIn2DArray {
    public static int countDigits(int number) {
        int count = 0;
        int n = number;
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }

    public static int[] getDigitsArray(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        int index = count - 1;
        while (number > 0) {
            digits[index--] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, 2);
        }
        return sum;
    }

    public static boolean isHarshad(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }
        int[][] result = new int[10][2];
        for (int i = 0; i < 10; i++) {
            result[i][0] = i;
            result[i][1] = freq[i];
        }
        return result;
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        int number = 122344;
        int[] digits = getDigitsArray(number);

        System.out.println("Number : " + number);
        System.out.println("Count of digits : " + countDigits(number));
        System.out.print("Digits : ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        System.out.println();
        System.out.println("Sum of digits : " + sumOfDigits(digits));
        System.out.println("Sum of squares of digits : " + sumOfSquares(digits));
        System.out.println("Is Harshad number : " + isHarshad(number, digits));

        System.out.println("Digit Frequencies : ");
        int[][] freq = digitFrequency(digits);
        for (int i = 0; i < freq.length; i++) {
            if (freq[i][1] > 0) {
                System.out.println("Digit : " + freq[i][0] + ", Frequency : " + freq[i][1]);
            }
        }
    }
}
