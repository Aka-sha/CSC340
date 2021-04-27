import Models.AnimeManga;
import Models.City;
import Models.Restaurant;
import db.UserDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    public static void main(String[] args) {
        UserDatabase userDB = new UserDatabase();

        //Testing Location API
        String ipAddress = "174.204.142.53"; // New York
        //City cityTitle = City.loadCityTitleByIP(ipAddress);
        //City cityLat = City.loadCityLatitudeByIP(ipAddress);
        //City cityLon = City.loadCityLongitudeByIP(ipAddress);
        //System.out.println("Address Based on New York IP: " + cityTitle.getCityTitle() + " " + cityLat.getLatitude() + " " + cityLon.getLongitude()); //prints New York 48.8271 -73.9359

        City city = City.loadCityResultsByAddress("1600 Pennsylvania Ave NW, Washington DC");
        List<String> restSearchQuery = new ArrayList<>();
        restSearchQuery.add(city.getLatitude()); //MUST STAY LATITUDE FOR TRANSLATOR (working on update!!!)
        restSearchQuery.add(city.getLongitude()); //MUST STAY LONGITUDE
        restSearchQuery.add("30"); //MUST STAY DISTANCE
        restSearchQuery.add("Japanese"); //MUST STAY CUISINE
        Restaurant rest = Restaurant.loadRestaurantResults(restSearchQuery);
        System.out.println(rest.getNameList());

        //Testing Restaurant API
        //SOME LOAD ITEMS RETURN "". THEY EXIST AND ARENT NULL!
        //String distance = "30";
        //String cuisine = "Japanese";
        //String restID = "407270267399819";
        //List<String> restSearchQuery = new ArrayList<>();
        //restSearchQuery.add(cityLat.getLatitude()); //MUST STAY LATITUDE FOR TRANSLATOR (working on update!!!)
        //restSearchQuery.add(cityLon.getLongitude()); //MUST STAY LONGITUDE
        //restSearchQuery.add(distance); //MUST STAY DISTANCE
        //restSearchQuery.add(cuisine); //MUST STAY CUISINE
        //Restaurant restaurantResults = Restaurant.loadRestaurantResults(restSearchQuery);
        //System.out.println(restaurantResults.getResults());

        //Testing AnimeManga API
        String type = "anime";
        String genre1 = "1";
        String genre2 = "10";
        String genre3 = "4";
        String orderBy = "start_date";
        String sort = "desc";
        //put this into a method for user preferences or search etc.
        List<String> searchQuery = new ArrayList<>();
        searchQuery.add(type); // TYPE MUST ALWAYS BE FIRST FOR URL TO WORK PROPERLY
        searchQuery.add(genre1);
        searchQuery.add(genre2);
        searchQuery.add(genre3);
        searchQuery.add(orderBy);
        searchQuery.add(sort);
        //AnimeManga animeSearch = AnimeManga.loadAnimeMangaTitleBySearch(type,  genre1, genre2, genre3,  orderBy, sort);
        AnimeManga animeSearch = AnimeManga.loadAnimeMangaDataBySearch(searchQuery);
        System.out.println(animeSearch.getTitleList().get(1));
        //List<Object> animeData = animeSearch.getData();
        //System.out.println(animeData);
        //AnimeManga animeRatingByID = AnimeManga.loadAnimeMangaRatingByID(id);
        //System.out.println("Anime Search Get Title: " + animeSearch.getTitle()); //Returns JSON File
        //System.out.println(animeRatingByID.getRating());


        //testing MySQL Queries for Database established above
        //for (int i = 0; i < userDB.getSize(); i++) {
            //UserProfile userProfile = new UserProfile();
            //userProfile.setUsername(userDB.getUsernameByIndex(i));
            //userProfile.setEmail(userDB.getEmailByIndex(i));
            //userProfile.setPassword(userDB.getPasswordByIndex(i));
            //userProfile.setAge(userDB.getAgeByIndex(i));
            //userProfile.setCity(cityTitle.getCityTitle());
//            userProfile.setIpAddress(ipAddress);
            //userProfile.save();
       // }

        //Testing the file loading
        userDB.loadUserDatabaseDefault();

        City cityTitle = City.loadCityResultsByAddress("1600 Pennsylvania Ave NW, Washington DC");
        //Testing the UserDatabase
        userDB.addNewApplicationUser("eHicks", "eHicks@uncg.edu", "HicksPass1", 18, cityTitle.getCityTitle(), 12345);
        userDB.addNewApplicationUser("ACarver", "akasha_1@uncg.edu", "AkashPass2", 21, cityTitle.getCityTitle(), 12345);
        userDB.addNewApplicationUser("aCandy", "wacruse@uncg.edu", "ijustReallyfuckinglovegators3", 23, cityTitle.getCityTitle(), 12345);
        userDB.addNewApplicationUser("eHicks", "eHicksOtherEmail@uncg.edu", "sneakysumbitch", 22, cityTitle.getCityTitle(), 12345);
        userDB.addNewApplicationUser("EHicks", "eHicksOtherOtherEmail@uncg.edu", "Sneakier Sum Bitch", 1000, cityTitle.getCityTitle(), 12345);
        for (int i = 0; i < userDB.getSize(); i++) {
            System.out.println(i + " USERNAME: " + userDB.getUsernameByIndex(i) + " \n PASSWORD: " + userDB.getPasswordByIndex(i) + " \n EMAIL: " + userDB.getEmailByIndex(i) +
                    "\n AGE: " + userDB.getAgeByIndex(i) + "\n CITY: " + userDB.getCityByIndex(i) + "\n IP ADDRESS: " + userDB.getZipCodeByIndex(i));
        }

        //Testing the file printing and saving
        System.out.println(userDB.printDatabase());
        userDB.saveUserDatabaseDefault();

        //Testing the merge-sort algorithm in case the user database becomes unsorted and needs fixing
        UserDatabase mergeDB = new UserDatabase();
        mergeDB.quickAddNewApplicationUser("eHicks", "", "", 0, "", 0);
        mergeDB.quickAddNewApplicationUser("ACarver", "", "", 0, "", 0);
        mergeDB.quickAddNewApplicationUser("aCandy", "", "", 0, "", 0);
        mergeDB.quickAddNewApplicationUser("TheMessiah", "", "", 0, "", 0);
        mergeDB.quickAddNewApplicationUser("kev1nDu", "", "", 0, "", 0);
        mergeDB.quickAddNewApplicationUser("BigQuig", "", "", 0, "", 0);
        System.out.println(mergeDB.printDatabase());
        mergeDB.mergeSortList();
        System.out.println(mergeDB.printDatabase());
        //Testing The GUI

        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
            Scene scene = new Scene(root, 1028, 579);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Welcome to Nakama Scouter");
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
