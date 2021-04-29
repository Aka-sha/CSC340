package UI;

import Models.City;
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
    private TextField reAddress;

    @FXML
    public void homePage(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
            Scene rooter = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(rooter);
            window.show();
    }

    @FXML
    public void welcome(ActionEvent event, String info) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, info, new ButtonType("Close", ButtonBar.ButtonData.YES));
        alert.setHeaderText(null);
        alert.setTitle("Welcome");
        alert.show();
    }

    @FXML
    public void alert(ActionEvent event, String info) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, info, new ButtonType("Close", ButtonBar.ButtonData.YES));
        alert.setHeaderText(null);
        alert.setTitle("Alert");
        alert.show();
    }

    @FXML
    void signup(ActionEvent event) throws IOException {
        UserDatabase userDB = new UserDatabase();
        userDB.loadUserDatabaseDefault();

        String userids = reUserid.getText();
        String passWords = rePass1.getText();
        String Confirm = rePass2.getText();
        String email = reEmail.getText();
        String zip = reZip.getText();
        int zipInt = Integer.parseInt(zip);
        String age = reAge.getText();
        int ageInt = Integer.parseInt(age);
        int min = age.compareTo("18");
        String address = reAddress.getText();
        City city = City.loadCityResultsByAddress(address);
        String empty = "";
        int error = 0;
        String info = "";



        if (!passWords.equals(Confirm)) {
            info += "Passwords are not matched. \n";
            error++;
        }
        if (userids.length() < 4) {
            info += "Username must be at least 4 characters in length. \n";
            error++;
        }
        if (passWords.length() < 8) {
            info += "Password must be at least 8 characters in length. \n";
            error++;
        }
        if (userids.equals(empty) || passWords.equals(empty) || Confirm.equals(empty) || email.equals(empty) || zip.equals(empty) || age.equals(empty) || address.equals((empty)) ) {
            info += "Please fill all the form. \n";
            error++;
        }
        if (min < 0) {
            info += "You need larger then 18 years old. \n";
            error++;
        }
        if (userids.contains(" ")){
            info += "Username must not contain any spaces. \n";
            error++;
        }
        if (checkUsernameForDuplicates(userids)){
            info += "The username " + userids + " is already being used by another account. \n";
            error++;
        }
        if (passWords.contains(" ")){
            info += "Password must not contain any spaces. \n";
            error++;
        }
        if (passWords.equals(passWords.toUpperCase()) || passWords.equals(passWords.toLowerCase())){
            info += "Password must contain both uppercase and lowercase letters. \n";
            error++;
        }
        if (!passWords.contains("0") && !passWords.contains("1") &&!passWords.contains("2") &&!passWords.contains("3") &&!passWords.contains("4") &&!passWords.contains("5") &&!passWords.contains("6") &&!passWords.contains("7") &&!passWords.contains("8") &&!passWords.contains("9")){
            info += "Password must contain at least one number. \n";
            error++;
        }
        if (userids.contains(";")){
            info += "Username must not contain a tab. \n";
            error++;
        }
        if (passWords.contains(";")){
            info += "Password must not contain a tab. \n";
            error++;
        }
        if (email.contains(";")){
            info += "Email must not contain a tab. \n";
            error++;
        }
        if (address.contains(";")){
            info += "Address must not contain a tab. \n";
            error++;
        }
        if(error != 0){
            alert(event, info);
        }
        if(error == 0) {
            info = userids + " Welcome To Anime Scouter.";
            userDB.addNewApplicationUser(userids, email, passWords, ageInt, city.getCityTitle(), zipInt);
            System.out.println(userDB.printDatabase());
            userDB.saveUserDatabaseDefault();


            welcome(event, info);
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
            Scene rooter = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(rooter);
            window.show();
            System.out.println(userids + " from " + city.getCityTitle() + " joined us");
        }
    }

    public boolean checkUsernameForDuplicates(String _userName) {
        UserDatabase userDB = new UserDatabase();
        userDB.loadUserDatabaseDefault();
        //First, check if database is empty. If so, return true.
        if (userDB.getSize() == 0) return false;
        if (userDB.getIndexByUsername(_userName) != -1) {
            System.out.println("The username " + _userName + " is already being used by another account.");
            return true;
        }
        return false;
    }

    @FXML
    public void clear(ActionEvent event) {
        reEmail.clear();
        rePass1.clear();
        reUserid.clear();
        rePass2.clear();
        reAge.clear();
        reZip.clear();
        reAddress.clear();
    }
}
