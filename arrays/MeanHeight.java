import java.util.*;
public class MeanHeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		double []height = new double[11];
		for(int i =0;i<height.length;i++) {
			height[i]=sc.nextDouble();
		}
		double sum =0;
		for(int j=0 ;j<height.length;j++) {
			sum+=height[j];
		}
		double mean = sum / height.length;
		  System.out.println("The mean of all the heights is: " + sum/11);
	}

}
