public class NumberChecker {
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

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArmstrong(int number, int[] digits) {
        int sum = 0;
        int power = digits.length;
        for (int d : digits) {
            sum += Math.pow(d, power);
        }
        return sum == number;
    }

    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }
        return new int[]{largest, secondLargest};
    }

    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) {
                secondSmallest = d;
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        int number = 153;
        int[] digits = getDigitsArray(number);
        System.out.println("Count of digits : " + countDigits(number));
        System.out.print("Digits : ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        System.out.println();
        System.out.println("Is Duck Number : " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number : " + isArmstrong(number, digits));
        int[] largest = findLargestAndSecondLargest(digits);
        System.out.println("Largest : " + largest[0]);
        System.out.println("Second Largest : " + largest[1]);
        int[] smallest = findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest : " + smallest[0]);
        System.out.println("Second Smallest : " + smallest[1]);
    }
}
