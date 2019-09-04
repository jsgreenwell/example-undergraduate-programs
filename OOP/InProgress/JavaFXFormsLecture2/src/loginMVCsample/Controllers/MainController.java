package loginMVCsample.Controllers;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

  @FXML
  private void getLogin(ActionEvent signinClicked) throws Exception {
    String user = username.getText().trim();
    String pass = password.getText().trim();

    if ((user != null && pass != null) && (!user.isEmpty() && !pass.isEmpty())){
      String validUser = users.get(user.toLowerCase());

      if (validUser != null && pass.equals(validUser)) {
        lm.goodLogin(signinClicked);
      } else {
        lm.badLogin(signinClicked);
      }
    } else {
        lm.badLogin(signinClicked);
    }

  }
}
