package UI;

import db.UserDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class signUpCon {
    @FXML
    private TextField reUserid;

    @FXML
    private PasswordField rePass1;

    @FXML
    private PasswordField rePass2;

    @FXML
    private TextField reEmail;

    @FXML
    private TextField reAge;

    @FXML
    private TextField reZip;

    @FXML
    private TextField reCity;

    @FXML
    public void homePage(ActionEvent event) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
            Scene rooter = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(rooter);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void welcome(ActionEvent event, String info) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, info, new ButtonType("Close", ButtonBar.ButtonData.YES));
        alert.setHeaderText(null);
        alert.setTitle("Welcome");
        alert.show();
    }

    @FXML
    public void alert(ActionEvent event, String info) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, info, new ButtonType("Close", ButtonBar.ButtonData.YES));
        alert.setHeaderText(null);
        alert.setTitle("Alert");
        alert.show();
    }

    @FXML
    void signup(ActionEvent event) throws IOException {
        String userids = reUserid.getText();
        String passWords = rePass1.getText();
        String Confirm = rePass2.getText();
        String email = reEmail.getText();
        String zip = reZip.getText();
        int zipInt = Integer.parseInt(zip);
        String age = reAge.getText();
        int ageInt = Integer.parseInt(age);
        int min = age.compareTo("18");
        String city = reCity.getText();
        String empty = "";


        if (!passWords.equals(Confirm)) {
            String info = "Passwords are not matched";
            alert(event, info);
        } else if (userids.length() < 4) {
            String info = "Username must be at least 4 characters in length.";
            alert(event, info);
        } else if (passWords.length() < 8) {
            String info = "Password must be at least 8 characters in length.";
            alert(event, info);
        } else if (userids.equals(empty) || passWords.equals(empty) || Confirm.equals(empty) || email.equals(empty) || zip.equals(empty) || age.equals(empty)) {
            String info = "Please fill all the form";
            alert(event, info);
        } else if (min < 0) {
            System.out.println(min);
            String info = "You need larger then 18 years old";
            alert(event, info);
        } else {
            String info = userids + " Welcome To Anime Scout";


            UserDatabase userDB = new UserDatabase();
            userDB.loadUserDatabaseDefault();
            userDB.addNewApplicationUser(userids, email, passWords, ageInt, city , zipInt);
            System.out.println(userDB.printDatabase());
            userDB.saveUserDatabaseDefault();


            welcome(event, info);
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
            Scene rooter = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(rooter);
            window.show();
            System.out.println(userids + " from " + city  + " joined us");
        }
    }


    @FXML
    public void clear(ActionEvent event) {
        reEmail.clear();
        rePass1.clear();
        reUserid.clear();
        rePass2.clear();
        reAge.clear();
        reZip.clear();
    }
}
