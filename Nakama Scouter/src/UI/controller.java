package UI;

import Models.City;
import db.UserDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class controller {
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
    private TextField userid;

    @FXML
    private PasswordField passWord;

    @FXML
    private ListView<String> animeRec;

    @FXML
    private TextArea animeSub;

    List<String> addStuff = new ArrayList<String>();

    @FXML
    private ImageView recImg;

    @FXML
    private Button close;


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
    public void loginPage(ActionEvent event) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
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
    public void loginB(ActionEvent event) throws Exception {
        userid.setUserData("admin");
        passWord.setUserData("admin123");
        String adminIDs = "admin";
        String adminPWs = "admin";
        String userids = userid.getText();
        String passWords = passWord.getText();
        if (userids.equals(userid.getUserData()) && passWords.equals(passWord.getUserData())) {
            System.out.println(userids + " login");
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
            Scene rooter = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(rooter);
            window.show();
        } else if (userids.equals(adminIDs) && passWords.equals(adminPWs)) {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/userlist.fxml"));
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
    void signup(ActionEvent event) throws IOException {
        String userids = reUserid.getText();
        String passWords = rePass1.getText();
        String Confirm = rePass2.getText();
        String email = reEmail.getText();
        String zip = reZip.getText();
        int zipInt = Integer.parseInt(zip);
        String age = reAge.getText();
        int ageInt = Integer.parseInt(age);
        String IP = "174.204.142.53";
        City cityTitle = City.loadCityResultsByAddress("");
        int min = age.compareTo("18");
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
            userDB.addNewApplicationUser(userids, email, passWords, ageInt, cityTitle.getCityTitle(), zipInt);
            userDB.saveUserDatabaseDefault();
            welcome(event, info);
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
            Scene rooter = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(rooter);
            window.show();
            System.out.println(userids + " from " + cityTitle.getCityTitle() + " joined us");
        }
    }


    @FXML
    public void subAnimeRec(ActionEvent event) {
        String sub = animeSub.getText();
        addStuff.add(sub);
        ObservableList<String> add = FXCollections.observableList(addStuff);
        animeRec.setItems(add);
        animeSub.clear();
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



    @FXML
    void animeDetail(ActionEvent event) throws IOException {
        Parent settings = FXMLLoader.load(getClass().getResource("/fxml/animeDetail.fxml"));
        Stage stage = new Stage();
        stage.setTitle("AnimeDetail");
        stage.setScene(new Scene(settings));
        stage.show();
    }

    @FXML
    void Close(ActionEvent event) throws IOException {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    @FXML
    private ListView<String> userList;

    @FXML
    void manage(MouseEvent event) {
            String selected = userList.getSelectionModel().getSelectedItem().toString();

    }

    @FXML
    void loadUser(ActionEvent event) {
        UserDatabase userDB = new UserDatabase();
        userDB.loadUserDatabaseDefault();
        ArrayList<String> userListA = new ArrayList();
        for (int i = 0; i < userDB.getSize(); i++) {
            userListA.add(userDB.getUsernameByIndex(i));
        }
        System.out.println(userListA);
        for (String userListString : userListA) {
            userList.getItems().add(userListString);
        }

    }
}