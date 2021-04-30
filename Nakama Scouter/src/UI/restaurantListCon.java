package UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Models.City;
import Models.Restaurant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class restaurantListCon {
    @FXML
    private TextField nearStreet;

    @FXML
    private TextField nearCity;

    @FXML
    private TextField nearDistance;

    @FXML
    private TextField nearState;

    @FXML
    private ListView<String> restColumn;

    @FXML
    private ListView<String> phoneColumn;

    @FXML
    private ListView<String> siteColumn;

    @FXML
    private ListView<String> priceColumn;

    @FXML
    private ListView<String> idColumn;

    @FXML
    public void homePage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        Scene rooter = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(rooter);
        window.show();
    }

    @FXML
    public void topPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/topAnime.fxml"));
        Parent Parent = loader.load();

        Scene Scene = new Scene(Parent);

        animeListCon controller = loader.getController();
        controller.loadImage(1);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(Scene);
        window.show();
    }


    @FXML
    void signPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/signup.fxml"));
        Parent Parent = loader.load();

        Scene Scene = new Scene(Parent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(Scene);
        window.show();
    }

    @FXML
    public void loginPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        Scene rooter = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(rooter);
        window.show();

    }

    @FXML
    void restaurantFind(ActionEvent event) {

        String street = nearStreet.getText();
        String city = nearCity.getText();
        String distance = nearDistance.getText();
        String state = nearState.getText();
        String address = street + ", " + city + " " + state;
        City loadCity = City.loadCityResultsByAddress(address);
        List<String> restSearchQuery = new ArrayList<>();
        restSearchQuery.add(loadCity.getLatitude());
        restSearchQuery.add(loadCity.getLongitude());
        restSearchQuery.add(distance);
        restSearchQuery.add("Japanese");
        Restaurant rest = Restaurant.loadRestaurantResults(restSearchQuery);
        List<String> nameList = new ArrayList<>();
        List<String> phoneList = new ArrayList<>();
        List<String> siteList = new ArrayList<>();
        List<String> priceList = new ArrayList<>();
        List<String> idList = new ArrayList<>();
        nameList = rest.getNameList();
        phoneList = rest.getPhoneList();
        siteList = rest.getWebsiteList();
        priceList = rest.getPriceRangeList();
        idList = rest.getIdList();
//        nameList.add("mac");
//        phoneList.add("2232232232");
//        siteList.add("www.mc.com");
//        priceList.add("$");
//        hoursList.add("0:00 - 23:00");
        restColumn.getItems().clear();
        phoneColumn.getItems().clear();
        siteColumn.getItems().clear();
        priceColumn.getItems().clear();
        idColumn.getItems().clear();
        for (String userListString : nameList) {
            restColumn.getItems().add(userListString);
        }
        for (String userListString : phoneList) {
            phoneColumn.getItems().add(userListString);
        }
        for (String userListString : siteList) {
            siteColumn.getItems().add(userListString);
        }
        for (String userListString : priceList) {
            priceColumn.getItems().add(userListString);
        }
        for (String userListString : idList) {
            idColumn.getItems().add(userListString);
        }

    }



}
