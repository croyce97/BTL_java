package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Control;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class MatchingGameHome{

    @FXML
    AnchorPane anchorPane;
    @FXML
    AnchorPane GameAnchorPane;


    public void playNow(ActionEvent actionEvent) {
        try {
                GameAnchorPane = FXMLLoader.load(getClass().getResource("/FXML/MatchingGame.fxml"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setMainPane(GameAnchorPane);
    }

    public void setMainPane(AnchorPane pane) {
        anchorPane.getChildren().clear();
        anchorPane.getChildren().addAll(pane);
    }
}




