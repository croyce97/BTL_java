package Controller.Game.QuizGame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class QuizGameHome {
    @FXML
    AnchorPane QuizAnchorPane;
    @FXML
    AnchorPane anchorPane;
    public void PlayNow(ActionEvent actionEvent) {
        try {
            QuizAnchorPane = FXMLLoader.load(getClass().getResource("/FXML/QuizGame.fxml"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setMainPane(QuizAnchorPane);
    }


    public void setMainPane(AnchorPane pane) {
        anchorPane.getChildren().clear();
        anchorPane.getChildren().addAll(pane);
    }


}
