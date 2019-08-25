package loginMVCsample.Models;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class LoginModel {

  public LoginModel() {

  }

  @FXML
  public void showLoggedIn(ActionEvent event) throws Exception {
    // You can also just println with @FXML annotation
    // System.out.println("You've been logged in successfully");

    Alert alert = new Alert(AlertType.CONFIRMATION, "Logged In Successfully", ButtonType.CLOSE);
    alert.showAndWait();
  }

}