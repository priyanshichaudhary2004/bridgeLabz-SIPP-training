import java.util.List;

interface MealPlan {
    void showMeals();
}

class VegetarianMeal implements MealPlan {
    private List<String> meals;

    VegetarianMeal(List<String> meals) {
        this.meals = meals;
    }

    @Override
    public void showMeals() {
        for (String meal : meals) {
            System.out.println("\n- " + meal);
        }
    }
}

class VeganMeal implements MealPlan {
    private List<String> meals;

    VeganMeal(List<String> meals) {
        this.meals = meals;
    }

    @Override
    public void showMeals() {
        for (String meal : meals) {
            System.out.println("\n- " + meal);
        }
    }
}

class KetoMeal implements MealPlan {
    private List<String> meals;

    KetoMeal(List<String> meals) {
        this.meals = meals;
    }

    @Override
    public void showMeals() {
        for (String meal : meals) {
            System.out.println("\n- " + meal);
        }
    }
}

class HighProteinMeal implements MealPlan {
    private List<String> meals;

    HighProteinMeal(List<String> meals) {
        this.meals = meals;
    }

    @Override
    public void showMeals() {
        for (String meal : meals) {
            System.out.println("\n- " + meal);
        }
    }
}

public class Meal<T extends MealPlan> {
    private T mealPlan;

    Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void displayPlan() {
        mealPlan.showMeals();
    }

    public static <T extends MealPlan> Meal<T> generateMealPlan(T plan) {
        return new Meal<>(plan);
    }
}

