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
        //Black Box testing (comment out if it's to be skipped)
        //blackBoxTest();
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

    /**
     * A method for testing every individual aspect of Nakama Scouter by comparing expected outputs with
     * the actual output.
     */
    public static void blackBoxTest() {
        //Use this address format. Surprisingly hard to fuck up for some reason...
        City city = City.loadCityResultsByAddress("");//24 Sussex Drive Ottawa ON");
        List<String> restSearchQuery = new ArrayList<>();
        restSearchQuery.add(city.getLatitude()); //MUST STAY LATITUDE FOR TRANSLATOR (working on update!!!)
        restSearchQuery.add(city.getLongitude()); //MUST STAY LONGITUDE
        restSearchQuery.add("30"); //MUST STAY DISTANCE
        restSearchQuery.add("Japanese"); //MUST STAY CUISINE
        Restaurant rest = Restaurant.loadRestaurantResults(restSearchQuery);
        System.out.println(rest.getNameList());
        System.out.println(rest.getPriceRangeList());
        System.out.println(rest.getPhoneList());

        //Testing the file loading, printing, and saving
        UserDatabase userDB = new UserDatabase();
        userDB.loadUserDatabaseDefault();
        System.out.println(userDB.printDatabase());
        userDB.saveUserDatabaseDefault();
        
        City cityTitle = City.loadCityResultsByAddress("1600 Pennsylvania Ave NW, Washington DC");
        //Creating an empty database for testing
        UserDatabase testDB = new UserDatabase();
        //Testing the UserDatabase
        testDB.addNewApplicationUser("eHicks", "eHicks@uncg.edu", "HicksPass1", 18, cityTitle.getCityTitle(), 12345);
        //Comparing
        blackBoxCompare(testDB.getUsernameByIndex(0), "eHicks");
        blackBoxCompare(testDB.getEmailByIndex(0), "eHicks@uncg.edu");
        blackBoxCompare(testDB.getPasswordByIndex(0), "HicksPass1");
        blackBoxCompare(testDB.getAgeByIndex(0), 18);
        blackBoxCompare(testDB.getCityByIndex(0), cityTitle.getCityTitle());
        blackBoxCompare(testDB.getZipCodeByIndex(0), 12345);
        //Add more users to the DB
        testDB.addNewApplicationUser("ACarver", "akasha_1@uncg.edu", "AkashPass2", 21, cityTitle.getCityTitle(), 12345);
        testDB.addNewApplicationUser("aCandy", "wacruse@uncg.edu", "ijustReallyfuckinglovegators3", 23, cityTitle.getCityTitle(), 12345);
        testDB.addNewApplicationUser("eHicks", "eHicksOtherEmail@uncg.edu", "sneakysumbitch", 22, cityTitle.getCityTitle(), 12345);
        testDB.addNewApplicationUser("EHicks", "eHicksOtherOtherEmail@uncg.edu", "Sneakier Sum Bitch", 1000, cityTitle.getCityTitle(), 12345);
        testDB.printDatabase();
        //Comparing
        blackBoxCompare(testDB.getIndexByUsername("eHicks"), 2);
        blackBoxCompare(testDB.getIndexByUsername("ACarver"), 1);
        blackBoxCompare(testDB.getIndexByUsername("aCandy"), 0);

        //Testing the quickAddNewApplication method
        UserDatabase mergeDB = new UserDatabase();
        mergeDB.quickAddNewApplicationUser("eHicks", "", "", 0, "", 0);
        mergeDB.quickAddNewApplicationUser("ACarver", "", "", 0, "", 0);
        mergeDB.quickAddNewApplicationUser("aCandy", "", "", 0, "", 0);
        mergeDB.quickAddNewApplicationUser("TheMessiah", "", "", 0, "", 0);
        mergeDB.quickAddNewApplicationUser("kev1nDu", "", "", 0, "", 0);
        mergeDB.quickAddNewApplicationUser("BigQuig", "", "", 0, "", 0);
        System.out.println("TESTING METHOD quickAddNewApplicationUser");
        //Comparing output
        blackBoxCompare(mergeDB.getUsernameByIndex(0), "eHicks");
        blackBoxCompare(mergeDB.getUsernameByIndex(1), "ACarver");
        blackBoxCompare(mergeDB.getUsernameByIndex(2), "aCandy");
        blackBoxCompare(mergeDB.getUsernameByIndex(3), "TheMessiah");
        blackBoxCompare(mergeDB.getUsernameByIndex(4), "kev1nDu");
        blackBoxCompare(mergeDB.getUsernameByIndex(5), "BigQuig");
        //Testing the merge-sort algorithm
        mergeDB.mergeSortList();
        //Comparing output
        blackBoxCompare(mergeDB.getUsernameByIndex(0), "aCandy");
        blackBoxCompare(mergeDB.getUsernameByIndex(1), "ACarver");
        blackBoxCompare(mergeDB.getUsernameByIndex(2), "BigQuig");
        blackBoxCompare(mergeDB.getUsernameByIndex(3), "eHicks");
        blackBoxCompare(mergeDB.getUsernameByIndex(4), "kev1nDu");
        blackBoxCompare(mergeDB.getUsernameByIndex(5), "TheMessiah");
    }

    /**
     * This method is to be used during black box testing to compare two strings to see if the expected and
     * received output match. Will not work well when used to compare objects that don't parse well into
     * String, like an image.
     * @param _actual
     * @param _expected
     */
    public static void blackBoxCompare(Object _actual, Object _expected) {
        String actual = _actual.toString();
        String expected = _expected.toString();
        System.out.println("EXPECTED OUTPUT: " + expected);
        System.out.println("RECEIVED OUTPUT: " + actual);
        if (actual.equals(expected))
            System.out.println("--------- SUCCESS ---------");
        else
            System.out.println("~~~ !ERROR! ~~~ !ERROR! ~~~");
    }
}