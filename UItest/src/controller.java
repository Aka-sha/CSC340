import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class controller {

    @FXML
    void login(ActionEvent event) {
  try {
      Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
      Stage stage = new Stage();
      stage.setTitle("Login");
      stage.setResizable(false);
      stage.setScene(new Scene(root, 600, 400));
      stage.showAndWait();
  } catch (IOException e) {
      e.printStackTrace();
  }
    }
}
