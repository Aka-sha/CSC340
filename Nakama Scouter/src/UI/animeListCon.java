package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class animeListCon {
    @FXML
    private ImageView t1Anime, t2Anime, t3Anime, t4Anime, t5Anime;

    @FXML
    private Label T1text, T2text, T3text, T4text, T5text;

    @FXML
    private Label T1name, T2name, T3name, T4name, T5name;

    int click = 0;

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
    public void topPage(ActionEvent event) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/topAnime.fxml"));
            Parent Parent = loader.load();

            Scene Scene = new Scene(Parent);



            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(Scene);
            window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public void nextList(ActionEvent event) {
        click++;
        loadImage(click);
    }

    public void loadImage(int n) {
        t1Anime.setImage(new Image("https://cdn.myanimelist.net/images/anime/1436/106694.jpg?s=d395802efdb5b4a093f094f0090b7a07"));
        T1name.setText("Itai no wa Iya nano de Bougyoryoku ni Kyokufuri Shitai to Omoimasu. II");
        T1text.setText("Second season of Itai no wa Iya nano de Bougyoryoku ni Kyokufuri Shitai to Omoimasu.");
        t2Anime.setImage(new Image("https://cdn.myanimelist.net/images/anime/1407/111469.jpg?s=57f3024519667ef0d0fd15beeea628c1"));
        T2name.setText("Dungeon ni Deai wo Motomeru no wa Machigatteiru Darou ka IV");
        T2text.setText("Fourth season of Dungeon ni Deai wo Motomeru no wa Machigatteiru Darou ka.");
        t3Anime.setImage(new Image("https://cdn.myanimelist.net/images/anime/1978/111973.jpg?s=611c7f900ef12f49707e02b5d7435bb4"));
        T3name.setText("Toku: Touken Ranbu - Hanamaru - Setsugetsuka");
        T3text.setText("Touken Ranbu: Hanamaru anime movie trilogy.");
        t4Anime.setImage(new Image("https://cdn.myanimelist.net/images/anime/1340/110088.jpg?s=ee67671d1f7730716efef5ba82681170"));
        T4name.setText("Ousama Ranking");
        T4text.setText("The web manga centers around Bojji, a deaf, powerless prince who cannot even wield a children's sword. As the firstborn son, he strives hard and dreams of becoming the world's greatest king. However,...");
        t5Anime.setImage(new Image("https://cdn.myanimelist.net/images/anime/1236/113727.jpg?s=83919aa2db778f788cb7b7664b802a59"));
        T5name.setText("Tensei shitara Slime Datta Ken 2nd Season Part 2");
        T5text.setText("Second half of Tensei shitara Slime Datta Ken 2nd Season.");
    }

    @FXML
    public void animeRec(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/recommendation_anime.fxml"));
        Scene rooter = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(rooter);
        window.show();
    }

}
