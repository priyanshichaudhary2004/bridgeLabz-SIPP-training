import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InsuranceClaimAnalysis {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        List<Claim> claims = new ArrayList<>();

        System.out.print("Enter number of claims : ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter claim type : ");
            String type = sc.nextLine();
            System.out.print("Enter claim amount : ");
            double amount = sc.nextDouble();
            sc.nextLine(); 
            claims.add(new Claim(type, amount));
        }

        // Calculate average claim amount per type
        Map<String, Double> avgClaims = claims.stream()
                .collect(Collectors.groupingBy(
                        Claim::getType,
                        Collectors.averagingDouble(Claim::getAmount)
                ));

        System.out.println("\nAverage Claim Amount by Type : ");
        avgClaims.forEach((type, avg) ->
                System.out.println(type + " : " + avg));
	}
}
