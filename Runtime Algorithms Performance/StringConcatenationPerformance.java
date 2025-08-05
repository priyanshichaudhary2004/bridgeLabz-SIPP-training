import java.util.Scanner;

public class StringConcatenationPerformance {

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of concatenation operations : ");
        int n = sc.nextInt();
        sc.close();

        System.out.println("\n--- String Concatenation Performance ---");

        //Using String (O(N²))
        long startString = System.nanoTime();
        String s = "";
        for (int i = 0; i < n; i++) {
            s += "a"; 
        }
        long endString = System.nanoTime();
        System.out.println("String (O(N²))         : " + formatTime(endString - startString));

        //Using StringBuilder (O(N))
        long startSB = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        long endSB = System.nanoTime();
        System.out.println("StringBuilder (O(N))   : " + formatTime(endSB - startSB));

        //Using StringBuffer (O(N))
        long startSBuf = System.nanoTime();
        StringBuffer sBuf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sBuf.append("a");
        }
        long endSBuf = System.nanoTime();
        System.out.println("StringBuffer (O(N))    : " + formatTime(endSBuf - startSBuf));

        System.out.println("\nStringBuilder & StringBuffer are much more efficient than String.");
        System.out.println("Use StringBuilder in single-threaded code and StringBuffer in multithreaded environments.");
    }

    // Convert nanoseconds to ms/s/min readable format
    private static String formatTime(long nanos) {
        long millis = nanos / 1_000_000;
        if (millis < 1000) {
        	return millis + " ms";
        }
        double seconds = millis / 1000.0;
        if (seconds < 60) {
        	return String.format("%.2f s", seconds);
        }
        double minutes = seconds / 60.0;
        return String.format("%.2f min", minutes);
    }
}
