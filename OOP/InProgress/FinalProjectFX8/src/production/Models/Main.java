package production.Models;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../Views/mainView.fxml"));
        primaryStage.setTitle("Production Management Tools");
        primaryStage.setScene(new Scene(root, 500, 425));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
