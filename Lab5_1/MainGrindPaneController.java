package bin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainGrindPaneController {
    Hello model;
    @FXML
    private Button ButtonHello;

    @FXML
    private Label MyLabel;

    @FXML
    private TextField MyText;

    @FXML
    void onButtonHelloPressed(ActionEvent event) {
        model = new Hello();
        model.setName(MyText.getText());
        MyLabel.setText(model.getHello());

    }

}
