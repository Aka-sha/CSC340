import Models.Recipe;
import Models.City;

public class Main {
    public static void main(String[] args) {
        int id = 716429; //returns "Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs"
        Recipe recipeTitle = Recipe.loadRecipeTitleById(id);
        Recipe recipeSummary = Recipe.loadSummaryById(id);
        Recipe recipeVegetarian = Recipe.loadIsVegetarianById(id);
        Recipe recipeVegan = Recipe.loadIsVeganById(id);
        Recipe recipePricePerServing = Recipe.loadPricePerServingById(id);
        Recipe recipeMinutes = Recipe.loadReadyInMinutesById(id);
        Recipe recipeServings = Recipe.loadServingsById(id);

        System.out.println("Recipe Title: " + recipeTitle.getTitle());
        System.out.println("Recipe Summary: " + recipeSummary.getSummary());
        System.out.println("Vegetarian: " + recipeVegetarian.getIsVegetarian());
        System.out.println("Vegan: " + recipeVegan.getIsVegan());
        System.out.println("Price Per Serving: " + recipePricePerServing.getPricePerServing());
        System.out.println("Minutes Needed to Cook: " + recipeMinutes.getReadyInMinutes());
        System.out.println("Servings: " + recipeServings.getServings());

        String ipAddress = "24.48.0.1"; //returns "Montreal"
        City cityTitle = City.loadCityTitleByIP(ipAddress);
        System.out.println(cityTitle.getCityTitle());
    }
}