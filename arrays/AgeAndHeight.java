import java.util.*;
public class AgeAndHeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		String[] names = {"Amar", "Akbar", "Anthony"};
		int [] age = new int[3];
		int [] height=new int[3];
		for(int i =0;i<age.length;i++) {
			age[i]=sc.nextInt();
		}
		for(int i=0;i<height.length;i++) {
			height[i]=sc.nextInt();
		}
		int youngestAge = age[0];
        int youngestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (age[i] < youngestAge) {
                youngestAge = age[i];
                youngestIndex = i;
            }
        }

        int tallestHeight = height[0];
        int tallestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (height[i] > tallestHeight) {
                tallestHeight = height[i];
                tallestIndex = i;
                System.out.println("\nThe youngest friend is " + names[youngestIndex] + " with age " + youngestAge + ".");
                System.out.println("The tallest friend is " + names[tallestIndex] + " with height " + tallestHeight + " cm.");
            }
        }
	}

}
