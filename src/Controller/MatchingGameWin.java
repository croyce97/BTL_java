package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Win implements Initializable {
    @FXML
    AnchorPane anchorPane;
    @FXML
    AnchorPane PlayAgain;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            PlayAgain = FXMLLoader.load(getClass().getResource("/FXML/StartGame.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void playAgain(ActionEvent actionEvent) {
        setPane(PlayAgain);

    }
    private void setPane(AnchorPane pane) {
        anchorPane.getChildren().clear();
        anchorPane.getChildren().addAll(pane);
    }
}
