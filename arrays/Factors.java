import java.util.*;
public class Factors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int num = sc.nextInt();
		int maxFactor = 10;
		int [] arr = new int[maxFactor];
		int index =0;
		for(int i =1 ;i<num;i++) {
			if(num % i == 0) {
				if(index == maxFactor) {
					maxFactor*=2;
					int []temp =new int[maxFactor];
					for(int j =0 ;j<index ;j++) {
						
					        temp[j] = arr[j]; 
					    }
					    arr=temp;
					}
				arr[index]=i;
				index++;
			}
		}
		 System.out.print("The factors of " + num + " are: ");
	        for (int i = 0; i < index; i++) {
	            System.out.print(arr[i] + " ");
	        }
	}

}
