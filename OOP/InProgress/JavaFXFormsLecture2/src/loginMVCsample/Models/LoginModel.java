package loginMVCsample.Models;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;


public class LoginModel {

  public LoginModel() {

  }

  @FXML
  public void badLogin(ActionEvent event) throws Exception {
    // You can also just println with @FXML annotation
    // System.out.println("Your username or password was incorrect");

    Alert alert = new Alert(AlertType.CONFIRMATION, "Your username or password is incorrect", ButtonType.CLOSE);
    alert.showAndWait();
  }

  @FXML
  public void goodLogin(ActionEvent event) throws Exception {
    Alert alert = new Alert(AlertType.CONFIRMATION, "Logged In Successfully", ButtonType.CLOSE);
    alert.showAndWait();
  }

}
