package Controller.Game.QuizGame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class QuizGameResult implements Initializable {
    @FXML
    public Label marks, markstext, correcttext, wrongtext;
    @FXML
    AnchorPane anchorPane;
    @FXML
    AnchorPane GameHome;

    @FXML
    public ProgressIndicator correct_progress, wrong_progress;
    int point = QuizGameController.getCorrectInt();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        marks.setText(point + "/10");
        markstext.setText(point + " Marks Scored");
        correcttext.setText("Correct Answers :" + point);
        wrongtext.setText( "Incorrect Answers : " + (10-point) );
        correct_progress.setProgress((double) point /10);
        wrong_progress.setProgress((double) (10-point) /10);
        try {
            GameHome = FXMLLoader.load(getClass().getResource("/FXML/GameHome.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void PlayAgain(ActionEvent actionEvent) {
        anchorPane.getChildren().clear();
        anchorPane.getChildren().addAll(GameHome);
    }
}
