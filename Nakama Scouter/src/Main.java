import Models.AnimeManga;
import Models.City;
import Models.Recipe;
import Models.Restaurant;
import db.UserProfile;
import db.UserDatabase;
import db.FileReadAndWriter;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        UserDatabase userDB = new UserDatabase();
//        //Testing Food API
//        //API will fail if used too many times in a short period of time.
//        int foodID = 716429; //returns "Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs"
//        Recipe recipeTitle = Recipe.loadRecipeTitleById(foodID);
//        Recipe recipeSummary = Recipe.loadSummaryById(foodID);
//        Recipe recipeVegetarian = Recipe.loadIsVegetarianById(foodID);
//        Recipe recipeVegan = Recipe.loadIsVeganById(foodID);
//        Recipe recipePricePerServing = Recipe.loadPricePerServingById(foodID);
//        Recipe recipeMinutes = Recipe.loadReadyInMinutesById(foodID);
//        Recipe recipeServings = Recipe.loadServingsById(foodID);
//        System.out.println("Recipe Title: " + recipeTitle.getTitle());
//        System.out.println("Recipe Summary: " + recipeSummary.getSummary());
//        System.out.println("Vegetarian: " + recipeVegetarian.getIsVegetarian());
//        System.out.println("Vegan: " + recipeVegan.getIsVegan());
//        System.out.println("Price Per Serving: " + recipePricePerServing.getPricePerServing());
//        System.out.println("Minutes Needed to Cook: " + recipeMinutes.getReadyInMinutes());
//        System.out.println("Servings: " + recipeServings.getServings());
//
//
        //Testing Location API
        String ipAddress = "174.204.142.53"; // New York
        City cityTitle = City.loadCityTitleByIP(ipAddress);
        City cityLat = City.loadCityLatitudeByIP(ipAddress);
        City cityLon = City.loadCityLongitudeByIP(ipAddress);
        System.out.println("Address Based on New York IP: " + cityTitle.getCityTitle() + " " + cityLat.getLatitude() + " " + cityLon.getLongitude()); //prints New York 48.8271 -73.9359


        //Testing Restaurant API
        int distance = 30;
        String cuisine = "Japanese";
        String restID = "407270267399819";
        Restaurant restaurantName = Restaurant.loadRestaurantName(cityLat.getLatitude(), cityLon.getLongitude(), distance, cuisine);
        Restaurant restaurantPhone = Restaurant.loadRestaurantPhone(cityLat.getLatitude(), cityLon.getLongitude(), distance, cuisine);
        System.out.println("Rest. Get Name: " + restaurantName.getRestaurantName());
        System.out.println("Rest. Get Phone: " + restaurantPhone.getRestaurantPhone());

        //Testing AnimeManga API
        String type = "anime";
        String id = "884";
        String genre1 = "1";
        String genre2 = "10";
        String genre3 = "4";
        String orderBy = "start_date";
        String sort = "desc";
        AnimeManga animeSearch = AnimeManga.loadAnimeMangaTitleBySearch(type,  genre1, genre2, genre3,  orderBy, sort);

        //AnimeManga animeRatingByID = AnimeManga.loadAnimeMangaRatingByID(id);
        System.out.println("Anime Search Get Title: " + animeSearch.getTitle()); //Returns JSON File
        //System.out.println(animeRatingByID.getRating());



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

        //Testing the file loading
        userDB.loadUserDatabaseDefault();

        //Testing the UserDatabase
        userDB.addNewApplicationUser("eHicks", "eHicks@uncg.edu", "HicksPass1", 18, cityTitle.getCityTitle(), ipAddress);
        userDB.addNewApplicationUser("ACarver", "akasha_1@uncg.edu", "AkashPass2", 21, cityTitle.getCityTitle(), ipAddress);
        userDB.addNewApplicationUser("aCandy", "wacruse@uncg.edu", "ijustReallyfuckinglovegators3", 23, cityTitle.getCityTitle(), ipAddress);
        userDB.addNewApplicationUser("eHicks", "eHicksOtherEmail@uncg.edu", "sneakysumbitch", 22, cityTitle.getCityTitle(), ipAddress);
        userDB.addNewApplicationUser("EHicks", "eHicksOtherOtherEmail@uncg.edu", "Sneakier Sum Bitch", 1000, cityTitle.getCityTitle(), ipAddress);
        for (int i = 0; i < userDB.getSize(); i++) {
            System.out.println(i + " USERNAME: " + userDB.getUsernameByIndex(i) + " \n PASSWORD: " + userDB.getPasswordByIndex(i) + " \n EMAIL: " + userDB.getEmailByIndex(i) +
                    "\n AGE: " + userDB.getAgeByIndex(i) + "\n CITY: " + userDB.getCityByIndex(i) + "\n IP ADDRESS: " + userDB.getIpAddressByIndex(i));
        }

        //Testing the file printing and saving
        System.out.println(userDB.printDatabase());
        userDB.saveUserDatabaseDefault();

        //Testing the merge-sort algorithm in case the user database becomes unsorted and needs fixing
        UserDatabase mergeDB = new UserDatabase();
        mergeDB.quickAddNewApplicationUser("eHicks", "", "", 0, "", "");
        mergeDB.quickAddNewApplicationUser("ACarver", "", "", 0, "", "");
        mergeDB.quickAddNewApplicationUser("aCandy", "", "", 0, "", "");
        mergeDB.quickAddNewApplicationUser("TheMessiah", "", "", 0, "", "");
        mergeDB.quickAddNewApplicationUser("kev1nDu", "", "", 0, "", "");
        mergeDB.quickAddNewApplicationUser("BigQuig", "", "", 0, "", "");
        System.out.println(mergeDB.printDatabase());
        mergeDB.mergeSortList();
        System.out.println(mergeDB.printDatabase());
    }
}