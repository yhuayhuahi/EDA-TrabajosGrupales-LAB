import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class SceneController {

    @FXML
    private TextArea myTextArea;

    @FXML
    void myButton(ActionEvent event) {
        Stage stage = (Stage) myTextArea.getScene().getWindow();
        String mytext = myTextArea.getText();
        System.out.println(mytext);
    }

}