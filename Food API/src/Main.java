import API.UserDatabase;
import API.UserProfile;
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

        //Testing the UserDatabase
        UserDatabase userDB = new UserDatabase();
        userDB.addNewApplicationUser("eHicks", "poopergeist");
        userDB.addNewApplicationUser("ACarver", "g0thVi0lence");
        userDB.addNewApplicationUser("aCandy", "ijustreallyfuckinglovegators");
        userDB.addNewApplicationUser("eHicks", "fuckthatothereHicks");
        userDB.addNewApplicationUser("Ehicks", "Roh roh, cheat da system.");
        for (int i = 0; i < userDB.getSize(); i++) System.out.println(i + ": USERNAME: " + userDB.getUsernameByIndex(i) + " /\tPASSWORD: " + userDB.getPasswordByIndex(i));
    }
}