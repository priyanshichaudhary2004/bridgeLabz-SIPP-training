import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonalizedMealGenerator {
	
	public static String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter meal category (vegetarian/vegan/keto/high-protein) : ");
        String category = sc.nextLine().trim().toLowerCase();
        
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("\nHello " + name + "!");
        System.out.println("Your " + capitalize(category) + " Meal Plan:");
        
        System.out.print("Enter number of meals you want to add : ");
        int n = sc.nextInt();
        sc.nextLine(); 

        List<String> mealList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter meal " + (i + 1) + " : ");
            mealList.add(sc.nextLine());
        }

        switch (category) {
            case "vegetarian":
                Meal<VegetarianMeal> veg = Meal.generateMealPlan(new VegetarianMeal(mealList));
                veg.displayPlan();
                break;

            case "vegan":
                Meal<VeganMeal> vegan = Meal.generateMealPlan(new VeganMeal(mealList));
                vegan.displayPlan();
                break;

            case "keto":
                Meal<KetoMeal> keto = Meal.generateMealPlan(new KetoMeal(mealList));
                keto.displayPlan();
                break;

            case "high-protein":
                Meal<HighProteinMeal> hp = Meal.generateMealPlan(new HighProteinMeal(mealList));
                hp.displayPlan();
                break;

            default:
                System.out.println("Invalid category.");
        }
	}
}
