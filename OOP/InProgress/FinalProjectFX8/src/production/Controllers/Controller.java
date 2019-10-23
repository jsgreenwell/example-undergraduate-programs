package production.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class Controller {

  public enum ItemType {
    AUDIO ("AU"), VISUAL ("VI"),
    AUDIOMOBILE ("AM"), VISUALMOBILE ("VM");

    private final String abbreviation;
    ItemType(String abbreviation) {
      this.abbreviation = abbreviation;
    }

    String getAbbrev() {
      return abbreviation;
    }
  }

  @FXML
  protected ComboBox itemTypeCmb;

  @FXML
  protected void fillComboBox() {
    for (ItemType it : ItemType.values()) {
      itemTypeCmb.getItems().add(it.getAbbrev());
    }
  }


}
