package loginMVCsample.Controllers;

import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import loginMVCsample.Models.LoginModel;

public class MainController {
  private LoginModel lm = new LoginModel();
  @FXML
  private TextField username;
  @FXML
  private TextField password;

  public MainController() {

  }

  @FXML
  private void getLogin(ActionEvent signinClicked) throws Exception {
    String user = username.getText();
    String pass = password.getText();

    if (user != null && pass != null) {
      if (!user.trim().isEmpty() && !pass.trim().isEmpty()) {
        lm.showLoggedIn(signinClicked);
      }
    }

  }
}
