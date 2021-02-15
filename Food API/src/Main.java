import Models.Recipe;

public class Main {
    public static void main(String[] args) {
        //Recipe goodRecipe = Recipe.loadRecipeTitleById(716429); //returns "Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs"
        //Recipe goodRecipe = Recipe.loadRecipeTitleById(209128); //returns "Dinner Tonight: Grilled Romesco-Style Pork"
        //Recipe goodRecipe = Recipe.loadRecipeTitleById(498576); //returns "Gnocchi in Parmesan Garlic Sauce"
        Recipe goodRecipe = Recipe.loadRecipeTitleById(123456); // returns "Apple Delight Canadian 1962"

        System.out.printf("Recipe Title: " + goodRecipe.getTitle());
    }
}
