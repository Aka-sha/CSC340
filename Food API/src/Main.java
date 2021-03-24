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

        String ipAddress = "174.204.142.53"; //returns New York
        City cityTitle = City.loadCityTitleByIP(ipAddress);
        System.out.println(cityTitle.getCityTitle());

        //Testing the UserDatabase
        UserDatabase userDB = new UserDatabase();
        userDB.addNewApplicationUser("eHicks", "eHicks@uncg.edu", "HicksPass", 18, cityTitle.getCityTitle(), ipAddress);
        userDB.addNewApplicationUser("ACarver", "akasha_1@uncg.edu", "AkashPass", 21, cityTitle.getCityTitle(), ipAddress);
        userDB.addNewApplicationUser("aCandy", "wacruse@uncg.edu", "ijustreallyfuckinglovegators", 23, cityTitle.getCityTitle(), ipAddress);
        userDB.addNewApplicationUser("eHicks", "eHicksOtherEmail@uncg.edu", "sneakysumbitch", 22, cityTitle.getCityTitle(), ipAddress);
        userDB.addNewApplicationUser("EHicks", "eHicksOtherOtherEmail@uncg.edu", "Sneakier Sum Bitch", 1000, cityTitle.getCityTitle(), ipAddress);
        for (int i = 0; i < userDB.getSize(); i++) {
            System.out.println(i + " USERNAME: " + userDB.getUsernameByIndex(i) + " \n PASSWORD: " + userDB.getPasswordByIndex(i) + " \n EMAIL: " + userDB.getEmailByIndex(i) +
                    "\n AGE: " + userDB.getAgeByIndex(i) + "\n CITY: " + userDB.getCityByIndex(i) + "\n IP ADDRESS: " + userDB.getIpAddressByIndex(i));
        }
    }
}