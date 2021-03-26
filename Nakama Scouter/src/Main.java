import Models.AnimeManga;
import Models.City;
import Models.Recipe;
import Models.Restaurant;
import db.UserProfile;
import db.UserDatabase;

public class Main {
    public static void main(String[] args) {

        //Testing Food API
        //API Fails randomly. CONSIDER REMOVING OR REPLACE
        int foodID = 716429; //returns "Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs"
        Recipe recipeTitle = Recipe.loadRecipeTitleById(foodID);
        Recipe recipeSummary = Recipe.loadSummaryById(foodID);
        Recipe recipeVegetarian = Recipe.loadIsVegetarianById(foodID);
        Recipe recipeVegan = Recipe.loadIsVeganById(foodID);
        Recipe recipePricePerServing = Recipe.loadPricePerServingById(foodID);
        Recipe recipeMinutes = Recipe.loadReadyInMinutesById(foodID);
        Recipe recipeServings = Recipe.loadServingsById(foodID);
        System.out.println("Recipe Title: " + recipeTitle.getTitle());
        System.out.println("Recipe Summary: " + recipeSummary.getSummary());
        System.out.println("Vegetarian: " + recipeVegetarian.getIsVegetarian());
        System.out.println("Vegan: " + recipeVegan.getIsVegan());
        System.out.println("Price Per Serving: " + recipePricePerServing.getPricePerServing());
        System.out.println("Minutes Needed to Cook: " + recipeMinutes.getReadyInMinutes());
        System.out.println("Servings: " + recipeServings.getServings());


        //Testing Location API
        String ipAddress = "174.204.142.53"; // New York
        City cityTitle = City.loadCityTitleByIP(ipAddress);
        City cityLat = City.loadCityLatitudeByIP(ipAddress);
        City cityLon = City.loadCityLongitudeByIP(ipAddress);
        System.out.println("Address Based on New York IP: " + cityTitle.getCityTitle() + " " + cityLat.getLatitude() + " " + cityLon.getLongitude()); //prints New York 48.8271 -73.9359


        //Testing Restaurant API
        //RestaurantApiTranslator NEEDS WORK!!!!!
        int distance = 30;
        String cuisine = "Japanese";
        String restID = "407270267399819";
        Restaurant restaurantResults = Restaurant.loadRestaurantResults(cityLat.getLatitude(), cityLon.getLongitude(), distance, cuisine);
        Restaurant restaurantName = Restaurant.loadRestaurantName(cityLat.getLatitude(), cityLon.getLongitude(), distance, cuisine);
        Restaurant restaurantData = Restaurant.loadRestaurantData(cityLat.getLatitude(), cityLon.getLongitude(), distance, cuisine);
        Restaurant restaurantPhone = Restaurant.loadRestaurantPhone(cityLat.getLatitude(), cityLon.getLongitude(), distance, cuisine);
        Restaurant restaurantWeb = Restaurant.loadRestaurantWebsite(cityLat.getLatitude(), cityLon.getLongitude(), distance, cuisine);
        Restaurant restaurantHours = Restaurant.loadRestaurantHours(cityLat.getLatitude(), cityLon.getLongitude(), distance, cuisine);
        Restaurant restaurantPrice = Restaurant.loadRestaurantPriceRange(cityLat.getLatitude(), cityLon.getLongitude(), distance, cuisine);
        //Restaurant restaurantNameByID = Restaurant.loadRestaurantNameByID(restID); //API won't connect to this link, API may be down. Tester gets not response
        //Restaurant restaurantPhoneByID = Restaurant.loadRestaurantPhoneByID(restID);
        //Restaurant restaurantWebByID = Restaurant.loadRestaurantWebsiteByID(restID);
        //Restaurant restaurantHoursByID = Restaurant.loadRestaurantHoursByID(restID);
        //Restaurant restaurantPriceByID = Restaurant.loadRestaurantPriceByID(restID);
        System.out.println("Rest. Get Results: " + restaurantResults.getTotalResults());
        System.out.println("Rest. Get Name: " + restaurantName.getRestaurantName());
        System.out.println("Restaurant Get Data: " + restaurantData.getData()); //RestaurantApiTranslator NEEDS WORK!!!!! Currently returns a JSON file of RESULTS (same issue)
        //System.out.println("Restaurant Name By ID: " + restaurantNameByID.getRestaurantName());

        //Testing AnimeManga API
        String type = "anime";
        String id = "884";
        String genre1 = "1";
        String genre2 = "10";
        String genre3 = "4";
        String orderBy = "start_date";
        String sort = "desc";
        AnimeManga animeSearch = AnimeManga.loadAnimeMangaTitleBySearch(type,  genre1, genre2, genre3,  orderBy, sort);

        /** //AnimeApiTranslator NEEDS WORK!!!!! Currently returns a JSON file of RESULTS

        AnimeManga animeTypeByID = AnimeManga.loadAnimeMangaTypeByID(id);
        AnimeManga animeGenreByID = AnimeManga.loadAnimeMangaGenreByID(id);
        AnimeManga animeURLByID = AnimeManga.loadAnimeMangaURLByID(id);
        AnimeManga animeImageURLByID = AnimeManga.loadAnimeMangaImageUrlByID(id);
        AnimeManga animeTitleByID = AnimeManga.loadAnimeMangaTitleByID(id);
        AnimeManga animeTitleEnglishByID = AnimeManga.loadAnimeMangaTitleEnglishByID(id);
        AnimeManga animeSynopsisByID = AnimeManga.loadAnimeMangaSynopsisByID(id);
        AnimeManga animeEpisodesByID = AnimeManga.loadAnimeMangaEpisodesByID(id);
        AnimeManga animeScoreByID = AnimeManga.loadAnimeMangaScoreByID(id);
         */
        //AnimeManga animeRatingByID = AnimeManga.loadAnimeMangaRatingByID(id);
        System.out.println("Anime Search Get Title: " + animeSearch.getTitle()); //Returns JSON File
        //System.out.println(animeRatingByID.getRating());


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