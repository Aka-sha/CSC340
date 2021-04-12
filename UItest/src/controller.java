import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class controller {

    @FXML
    public void homePage(ActionEvent event) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));
            Scene rooter = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(rooter);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void topPage(ActionEvent event) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/topAnime.fxml"));
            Scene rooter = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(rooter);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void signPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/signup.fxml"));
        Scene rooter = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(rooter);
        window.show();
    }

    @FXML
    public void loginPage(ActionEvent event) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/login.fxml"));
            Scene rooter = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(rooter);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void alert(ActionEvent event, String info) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, info, new ButtonType("Close", ButtonBar.ButtonData.YES));
        alert.setHeaderText(null);
        alert.setTitle("Alert");
        alert.show();
    }
    @FXML
    public void welcome(ActionEvent event, String info) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, info, new ButtonType("Close", ButtonBar.ButtonData.YES));
        alert.setHeaderText(null);
        alert.setTitle("Welcome");
        alert.show();
    }

    @FXML
    private TextField userid;
    @FXML
    private PasswordField passWord;

    @FXML
    public void loginB(ActionEvent event) throws Exception {
        userid.setUserData("admin");
        passWord.setUserData("admin123");
        String userids = userid.getText();
        String passWords = passWord.getText();
        if (userids.equals(userid.getUserData()) && passWords.equals(passWord.getUserData())) {
            System.out.println(userids + " login");
            Parent root = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));
            Scene rooter = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(rooter);
            window.show();
        } else {
            String info = "Wrong username or password";
            alert(event, info);
        }
    }

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
    private TextField reCity;

    @FXML
    void signup(ActionEvent event) throws IOException {
        String userids = reUserid.getText();
        String passWords = rePass1.getText();
        String Confirm = rePass2.getText();
        String email = reEmail.getText();
        String city = reCity.getText();
        String age = reAge.getText();
        int min = age.compareTo("18");
        String empty = "";


        if (!passWords.equals(Confirm)) {
            String info = "Passwords are not matched";
            alert(event, info);
        } else if (userids.equals(empty) || passWords.equals(empty) || Confirm.equals(empty) || email.equals(empty) || city.equals(empty) || age.equals(empty)) {
            String info = "Please fill all the form";
            alert(event, info);
        } else if (min < 0) {
            System.out.println(min);
            String info = "You need larger then 18 years old";
            alert(event, info);
        } else {
            String info = userids + " Welcome To Anime Scout";
            welcome(event, info);
            Parent root = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));
            Scene rooter = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(rooter);
            window.show();
            System.out.println(userids + " from " + city + " joined us");
        }
    }


    @FXML
    void clear(ActionEvent event) {
        reEmail.clear();
        rePass1.clear();
        reUserid.clear();
        rePass2.clear();
        reAge.clear();
        reCity.clear();
    }

}
