package control_flow_statments;
import java.util.*;
public class youngest_friend {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        
	        System.out.print("Enter Amar's age: ");
	        int ageAmar = sc.nextInt();
	        System.out.print("Enter Akbar's age: ");
	        int ageAkbar = sc.nextInt();
	        System.out.print("Enter Anthony's age: ");
	        int ageAnthony = sc.nextInt();

	        
	        System.out.print("Enter Amar's height: ");
	        int heightAmar = sc.nextInt();
	        System.out.print("Enter Akbar's height: ");
	        int heightAkbar = sc.nextInt();
	        System.out.print("Enter Anthony's height: ");
	        int heightAnthony = sc.nextInt();
	        
	        int youngestAge= ageAmar;
	        String youngestFriend= "Amar";
	        if(ageAkbar<youngestAge) {
	        	youngestAge= ageAkbar;
	        	youngestFriend= "Akbar";
	        }else(ageAnthony < youngestAge){
	        	youngestAge= ageAkbar;
	        	youngestFriend= "Akbar";
	        }
	        

}
}