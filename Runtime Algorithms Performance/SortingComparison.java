import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortingComparison {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dataset size (e.g. 1000, 10000, 1000000) : ");
        int size = sc.nextInt();

        int[] originalArray = generateRandomArray(size);

        System.out.println("\n--- Sorting Performance ---");

        // Bubble Sort (only for small size)
        if (size <= 10000) {
            int[] bubbleArray = Arrays.copyOf(originalArray, originalArray.length);
            long start = System.nanoTime();
            bubbleSort(bubbleArray);
            long end = System.nanoTime();
            System.out.println("Bubble Sort (O(N²)) : " + (end - start) / 1_000_000 + " ms");
        } else {
            System.out.println("Bubble Sort (O(N²)) : Skipped (too slow for large data)");
        }

        // Merge Sort
        int[] mergeArray = Arrays.copyOf(originalArray, originalArray.length);
        long startMerge = System.nanoTime();
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        long endMerge = System.nanoTime();
        System.out.println("Merge Sort (O(N log N)) : " + (endMerge - startMerge) / 1_000_000 + " ms");

        // Quick Sort
        int[] quickArray = Arrays.copyOf(originalArray, originalArray.length);
        long startQuick = System.nanoTime();
        quickSort(quickArray, 0, quickArray.length - 1);
        long endQuick = System.nanoTime();
        System.out.println("Quick Sort (O(N log N)) : " + (endQuick - startQuick) / 1_000_000 + " ms");

        System.out.println("\nBubble Sort is impractical for large datasets.");
        System.out.println("Merge Sort & Quick Sort perform well.");
    }

    //Generate random array
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size);
        }
        return array;
    }

    //Bubble Sort (O(N^2))
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    //Merge Sort (O(N log N))
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    //Quick Sort (O(N log N))
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
