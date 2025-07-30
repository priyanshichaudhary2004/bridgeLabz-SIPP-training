import java.util.Scanner;

public class CompareStringBufferWithBuilder {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = 0;
		while(true) {
			System.out.print("Enter number of times to concatenate the string : ");
			if(sc.hasNextInt()) {
				n = sc.nextInt();
				sc.nextLine();
				break;
			} else {
				System.out.println("Please enter a valid number.");
				sc.nextLine();
			}
		}
		
		String strToConcat = "hello";
		
		StringBuffer sbuffer = new StringBuffer();
		long startBuffer = System.nanoTime();
		for(int i = 0; i < n; i++) {
			sbuffer.append(strToConcat);
		}
		
		long endBuffer = System.nanoTime();
		long timeBuffer = endBuffer - startBuffer;
		
		StringBuilder sbuilder = new StringBuilder();
		long startBuilder = System.nanoTime();
		for(int i = 0; i < n; i++) {
			sbuilder.append(strToConcat);
		}
		
		long endBuilder = System.nanoTime();
		long timeBuilder = endBuilder - startBuilder;
		
		System.out.println("\n---- Performance Comaparison ----");
		System.out.println("StringBuffer Time Taken : " + timeBuffer / 1_000_000.0 + " ms");
		System.out.println("StringBuilder Time Taken : " + timeBuilder / 1_000_000.0 + " ms");
	}
}
