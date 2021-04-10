import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class controller {
    @FXML
    private Button mov;

    @FXML
    public void login(ActionEvent event) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setResizable(false);
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            Stage primaryStage = (Stage) mov.getScene().getWindow();
            primaryStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button home;

    @FXML
    public void home(ActionEvent event) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Welcome to Nakama Scouter");
            stage.setResizable(false);
            stage.setScene(new Scene(root, 1028, 579));
            stage.show();
            Stage primaryStage = (Stage) home.getScene().getWindow();
            primaryStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button top;

    @FXML
    public void topa(ActionEvent event) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("topAnime.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Top Anime");
            stage.setResizable(false);
            stage.setScene(new Scene(root, 1028, 579));
            stage.show();
            Stage primaryStage = (Stage) top.getScene().getWindow();
            primaryStage.close();
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
    private TextField userid;
    @FXML
    private PasswordField passWord;
    @FXML
    private Button sub;

    @FXML
    public void loginB(ActionEvent event) throws Exception {
        userid.setUserData("admin");
        passWord.setUserData("admin123");
        String userids = userid.getText();
        String passWords = passWord.getText();
        if (userids.equals(userid.getUserData()) && passWords.equals(passWord.getUserData())) {
            System.out.println("admin login");
            Stage primaryStage = (Stage) sub.getScene().getWindow();
            primaryStage.close();
            main we = new main();
            Stage stage = new Stage();
            we.start(stage);
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
    private PasswordField reEmail;

    @FXML
    private Button clear;

    @FXML
    void clear(ActionEvent event) {
        reEmail.clear();
        rePass1.clear();
        reUserid.clear();
        rePass2.clear();
    }

}
