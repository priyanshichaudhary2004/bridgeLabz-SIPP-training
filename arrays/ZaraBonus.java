import java.util.*;
public class ZaraBonus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double []salary=new double[10];
		double [] year =new double[10];
		double []newSalary = new double[10];
		double []bonus =new double[10];
		double totalbonus=0 ,totaloldsalary=0 , newsalary=0;
		for(int i =0;i<10;i++) {
			System.out.println("Enter details of employee: ");
			System.out.println("Enter salary");
			double sal =sc.nextDouble();
			System.out.println("Year of services: ");
			double yrs=sc.nextDouble();
			if(sal <=0 || yrs<0) {
				System.out.println("Invalid input.");
				i--;
				continue;
			}
			salary[i]=sal;
			year[i]=yrs;
		}
			for(int i=0;i<10;i++) {
				if(year[i]>5) {
					bonus[i]=0.05*salary[i];
			}
				else {
					bonus[i]=0.02*salary[i];
				}
				newSalary[i] = salary[i] + bonus[i];

	            totalbonus += bonus[i];
	            totaloldsalary += salary[i];
	            newsalary += newSalary[i];
	        }

			System.out.println("Employee-wise Details:");
			System.out.println("Emp  Old Salary  Years  Bonus  New Salary");

			for (int i = 0; i < 10; i++) {
			    System.out.println(
			        (i + 1) + "    " +
			        salary[i] + "      " +
			        year[i] + "     " +
			        bonus[i] + "    " +
			        newSalary[i]
			    );
			}

			System.out.println();
			System.out.println("Total Bonus Payout: ₹" + totalbonus);
			System.out.println("Total Old Salary: ₹" + totaloldsalary);
			System.out.println("Total New Salary: ₹" + newsalary);

		}

	}

