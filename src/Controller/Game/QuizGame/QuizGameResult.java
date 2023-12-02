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
    public Label marks, markstext, correcttext, wrongtext,remark;
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
        if (QuizGameController.getCorrectInt()<2) {
            remark.setText("Oh no..! You have failed the quiz. It seems that you need to improve your general knowledge. Practice daily! Check your results here.");
        } else if (QuizGameController.getCorrectInt()>=2 && QuizGameController.getCorrectInt()<5) {
            remark.setText("Oops..! You have scored less marks. It seems like you need to improve your general knowledge. Check your results here.");
        } else if (QuizGameController.getCorrectInt()>=5 && QuizGameController.getCorrectInt()<=7) {
            remark.setText("Good. A bit more improvement might help you to get better results. Practice is the key to success. Check your results here.");
        } else if (QuizGameController.getCorrectInt()==8 || QuizGameController.getCorrectInt()==9) {
            remark.setText("Congratulations! Its your hardwork and determination which helped you to score good marks. Check you results here.");
        } else if (QuizGameController.getCorrectInt()==10) {
            remark.setText("Congratulations! You have passed the quiz with full marks because of your hardwork and dedication towards studies. Keep it up! Check your results here.");
        }
        try {
            GameHome = FXMLLoader.load(getClass().getResource("/FXML/GameHome.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void PlayAgain(ActionEvent actionEvent) {
        anchorPane.getChildren().clear();
        anchorPane.getChildren().addAll(GameHome);
        point =0;
        QuizGameController.setCorrectInt(0);
    }
}
