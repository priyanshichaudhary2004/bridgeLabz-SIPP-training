import java.util.*;
public class Vote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [] ages = new int[10];
		for(int i =0;i<ages.length;i++) {
			ages[i]=sc.nextInt();
		}
		System.out.println("Voting eligibility result: ");
		for( int i =0;i<ages.length;i++) {
			int age = ages[i];
		
			if (age < 0) {
                System.out.println("Student " + (i + 1) + ": Invalid age entered.");
            } else if (age >= 18) {
                System.out.println("Student " + (i + 1) + " with age " + age + " can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " with age " + age + " cannot vote.");
            }


	}
	}

}
