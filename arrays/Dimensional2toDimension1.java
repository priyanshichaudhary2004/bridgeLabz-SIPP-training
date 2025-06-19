import java.util.*;
public class Dimensional2toDimension1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of rows: ");
		int row = sc.nextInt();
		System.out.print("Enter the number of columns: ");
		int column = sc.nextInt();
		int [][] matrix = new int[row][column];
		for(int i =0;i<row;i++) {
			for(int j=0;j<column;j++) {
				matrix[i][j]=sc.nextInt();
			}
		}
		int []arr =new int[row*column];
		int index =0;
		for(int i =0;i<row;i++) {
			for(int j=0;j<column;j++) {
				arr[index]=matrix[i][j];
				index++;
			}
			
		}
		System.out.println("1D array: ");
		for(int i =0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}

	}

}
