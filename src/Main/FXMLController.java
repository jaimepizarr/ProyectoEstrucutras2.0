package Main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.media.MediaView;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MediaView mediaView;

    @FXML
    void initialize() {
        assert mediaView != null : "fx:id=\"mediaView\" was not injected: check your FXML file 'FXML.fxml'.";

    }
}
