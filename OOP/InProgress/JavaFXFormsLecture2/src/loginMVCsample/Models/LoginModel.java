package loginMVCsample.Models;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/***
 * <h2>Model for login screen (currently only screen so also the main module).</h2>
 * <p>Gives an alert based on a good login or bad login.</p>
 */

public class LoginModel {

  public LoginModel() {

  }

  /***
   * <h3>Alert for incorrect username or password.</h3>
   *
   * @throws Exception Later iteration to add exception handling
   */
  @FXML
  public void badLogin() throws Exception {
    // You can also just println with @FXML annotation
    // System.out.println("Your username or password was incorrect");

    Alert alert = new Alert(AlertType.CONFIRMATION,
        "Your username or password is incorrect", ButtonType.CLOSE);
    alert.showAndWait();
  }

  /***
   * <h3>Alert for correct username and password.</h3>
   *
   * @throws Exception Later iteration for adding handling
   */
  @FXML
  public void goodLogin() throws Exception {
    Alert alert = new Alert(AlertType.CONFIRMATION,
        "Logged In Successfully", ButtonType.CLOSE);
    alert.showAndWait();
  }

}
