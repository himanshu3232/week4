package org.capgemini.problem_4;

import java.util.*;

// MealPlan interface defining common structure
interface MealPlan {
    String getMealName();
    int getCalories();
}

// Different meal plan implementations
class VegetarianMeal implements MealPlan {
    private String mealName;
    private int calories;

    public VegetarianMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    public String getMealName() {
        return mealName;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return mealName + " (" + calories + " kcal) - Vegetarian";
    }
}

class VeganMeal implements MealPlan {
    private String mealName;
    private int calories;

    public VeganMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    public String getMealName() {
        return mealName;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return mealName + " (" + calories + " kcal) - Vegan";
    }
}

class KetoMeal implements MealPlan {
    private String mealName;
    private int calories;

    public KetoMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    public String getMealName() {
        return mealName;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return mealName + " (" + calories + " kcal) - Keto";
    }
}

// Generic Meal Class
class Meal<T extends MealPlan> {
    private final List<T> meals = new ArrayList<>();

    public void addMeal(T meal) {
        meals.add(meal);
    }

    public void displayMeals() {
        for (T meal : meals) {
            System.out.println(meal);
        }
    }
}

// Meal Plan Generator with Generic Method
class MealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(List<T> meals) {
        System.out.println("Generated Meal Plan:");
        for (T meal : meals) {
            System.out.println(meal);
        }
    }
}

// Main Class for Testing
public class PersonalizedMealPlan {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMeals = new Meal<>();
        vegetarianMeals.addMeal(new VegetarianMeal("Grilled Paneer Salad", 350));
        vegetarianMeals.addMeal(new VegetarianMeal("Vegetable Stir Fry", 400));

        Meal<VeganMeal> veganMeals = new Meal<>();
        veganMeals.addMeal(new VeganMeal("Tofu Scramble", 300));
        veganMeals.addMeal(new VeganMeal("Quinoa and Chickpea Bowl", 450));

        Meal<KetoMeal> ketoMeals = new Meal<>();
        ketoMeals.addMeal(new KetoMeal("Avocado Chicken Salad", 500));
        ketoMeals.addMeal(new KetoMeal("Salmon with Asparagus", 550));

        System.out.println("Vegetarian Meals:");
        vegetarianMeals.displayMeals();

        System.out.println("\nVegan Meals:");
        veganMeals.displayMeals();

        System.out.println("\nKeto Meals:");
        ketoMeals.displayMeals();

        System.out.println("\nPersonalized Meal Plan:");
        List<MealPlan> personalizedPlan = Arrays.asList(
                new VegetarianMeal("Grilled Paneer Salad", 350),
                new VeganMeal("Tofu Scramble", 300),
                new KetoMeal("Salmon with Asparagus", 550)
        );
        MealPlanGenerator.generateMealPlan(personalizedPlan);
    }
}

