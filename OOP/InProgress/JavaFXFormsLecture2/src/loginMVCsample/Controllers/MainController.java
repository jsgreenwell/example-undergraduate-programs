package loginMVCsample.Controllers;

import java.util.HashMap;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import loginMVCsample.Models.LoginModel;

public class MainController {

  private LoginModel lm = new LoginModel();

  // This Map will change to a database after H2 introduction
  // This is not the way to build a Map in Java 9+
  private Map<String, String> users = new HashMap<String, String>() {{
      put("greenwell", "cop3003");
      put("samuel", "otherPassword");
  }};

  @FXML
  private TextField username;
  @FXML
  private TextField password;

  public MainController() {

  }

  /***
   * <h3>Event for Login Screen - on login button press.</h3>
   *
   * @param signinClicked Currently not used but leaving for later
   * @throws Exception Added in later iteration
   */
  @FXML
  private void getLogin(ActionEvent signinClicked) throws Exception {
    String user = username.getText().trim();
    String pass = password.getText().trim();

    // Technically user & pass should never be "null" but checking doesn't hurt
    if ((user != null && pass != null) && (!user.isEmpty() && !pass.isEmpty())) {
      String validUser = users.get(user.toLowerCase());

      if (pass.equals(validUser)) {
        lm.goodLogin();
      } else {
        lm.badLogin();
      }
    } else {
      lm.badLogin();
    }

  }
}
