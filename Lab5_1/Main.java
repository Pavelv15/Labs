package bin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class Main extends  Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        GridPane root = FXMLLoader.load(getClass().getResource("MainGrindPane.fxml"));

        Scene scene =  new Scene(root,400,300);
        stage.setScene(scene);
        stage.show();





    }
}
