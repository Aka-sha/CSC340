import Models.AnimeManga;
import Models.City;
import Models.Recipe;
import Models.Restaurant;
import db.UserProfile;
import db.UserDatabase;

public class Main {
    public static void main(String[] args) {

        //Testing Food API
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


        //Testing Location API
        String ipAddress = "174.204.142.53"; //returns New York
        City cityTitle = City.loadCityTitleByIP(ipAddress);
        City cityLat = City.loadCityLatitudeByIP(ipAddress);
        City cityLon = City.loadCityLongitudeByIP(ipAddress);
        System.out.println(cityTitle.getCityTitle() + " " + cityLat.getLatitude() + " " + cityLon.getLongitude()); //prints New York 48.8271 -73.9359


        //Testing Restaurant API
        Restaurant restaurantResults = Restaurant.loadRestaurantResults(cityLat.getLatitude(), cityLon.getLongitude(), 30, "Japanese");
        Restaurant restaurantName = Restaurant.loadRestaurantName(cityLat.getLatitude(), cityLon.getLongitude(), 30, "Japanese");
        Restaurant restaurantData = Restaurant.loadRestaurantData(cityLat.getLatitude(), cityLon.getLongitude(), 30, "Japanese");
        System.out.println(restaurantResults.getTotalResults());
        System.out.println(restaurantName.getRestaurantName()); //TRANSLATOR NEEDS WORK!!!!!
        System.out.println(restaurantData.getData());


        //Testing AnimeManga API
        AnimeManga animeSearch = AnimeManga.loadAnimeMangaTitleBySearch("anime", "1", "10", "4", "start_date", "desc");
        AnimeManga animeTitle = AnimeManga.loadAnimeMangaTitleByID("884");
        System.out.println(animeSearch.getTitle());
        System.out.println(animeTitle.getTitle());

        
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

        //testing MySQL Queries for Database established above
        for (int i = 0; i < userDB.getSize(); i++) {
            UserProfile userProfile = new UserProfile();
            userProfile.setUsername(userDB.getUsernameByIndex(i));
            userProfile.setEmail(userDB.getEmailByIndex(i));
            userProfile.setPassword(userDB.getPasswordByIndex(i));
            userProfile.setAge(userDB.getAgeByIndex(i));
            userProfile.setCity(cityTitle.getCityTitle());
            userProfile.setIpAddress(ipAddress);
            userProfile.save();
        }
    }
}