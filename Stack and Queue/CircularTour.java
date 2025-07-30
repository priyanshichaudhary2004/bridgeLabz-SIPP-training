import java.util.Scanner;

public class CircularTour {
	//Function to find the starting pump index
	public static int findStartingPoint(int[] petrol, int[] distance) {
		int n = petrol.length;
		int start = 0;
		int surplus = 0;
		int deflict = 0;
		
		for(int i = 0; i < n; i++) {
			surplus += petrol[i] - distance[i];
			
			if(surplus < 0) {
				start = i + 1;
				deflict += surplus;
				surplus  = 0;
			}
		}
		return (surplus + deflict >= 0) ? start : -1; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of petrol pumps : ");
        int n = sc.nextInt();

        int[] petrol = new int[n];
        int[] distance = new int[n];

        System.out.println("Enter petrol and distance for each pump : ");
        
        for(int i = 0; i < n; i++) {
        	System.out.print("Pump " + (i + 1) + " - Petrol : ");
        	petrol[i] = sc.nextInt();
        	System.out.print("Pump " + (i + 1) + " - Distance to next : ");
        	distance[i] = sc.nextInt();
        }
        
        int start = findStartingPoint(petrol, distance);
        if(start != -1) {
        	System.out.println("Start at petrol pump index : " + start);
        } else {
        	System.out.println("No solution possible.");
        }
	}

}
