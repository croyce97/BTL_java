package Controller.Game.QuizGame;

import Data.LoadWordFromDataBase;
import Data.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class QuizGameController {
    @FXML
    public Label question;

    @FXML
    public Button opt1, opt2, opt3, opt4;

    @FXML
    Label Correct;
    @FXML
    Label Count;
    private final Random random = new Random();

    @FXML
    private void initialize() {
        setAll();
    }
    private void setCorrect(int correct) {
        Correct.setText(String.valueOf(correct));
    }
    private void setCount(int count) {
        Count.setText(count + "/10");
    }
    private void setAnswerToButton(String answer,Button button) {
        button.setText(answer);
    }
    private void SetQuestion(String questionToLabel) {
        String s = "What mean of \" " + questionToLabel + " \" ?";
        question.setText(s);
    }
    private int trueAnswer;
    private void setAll() {
        int d = random.nextInt(1,100);
        trueAnswer = d%4 +1;
        Word wordTrue = LoadWordFromDataBase.List.get(d);
        Word wordFalse1 = LoadWordFromDataBase.List.get(d+1);
        Word wordFalse2 = LoadWordFromDataBase.List.get(d+2);
        Word wordFalse3 = LoadWordFromDataBase.List.get(d+3);
        switch (trueAnswer) {
            case 1:
                setAnswerToButton(wordTrue.getMeanFromWord(),opt1);
                setAnswerToButton(wordFalse1.getMeanFromWord(),opt2);
                setAnswerToButton(wordFalse2.getMeanFromWord(),opt3);
                setAnswerToButton(wordFalse3.getMeanFromWord(),opt4);
            case 2:
                setAnswerToButton(wordTrue.getMeanFromWord(),opt2);
                setAnswerToButton(wordFalse1.getMeanFromWord(),opt1);
                setAnswerToButton(wordFalse2.getMeanFromWord(),opt3);
                setAnswerToButton(wordFalse3.getMeanFromWord(),opt4);
            case 3:
                setAnswerToButton(wordTrue.getMeanFromWord(),opt3);
                setAnswerToButton(wordFalse1.getMeanFromWord(),opt1);
                setAnswerToButton(wordFalse2.getMeanFromWord(),opt2);
                setAnswerToButton(wordFalse3.getMeanFromWord(),opt4);
            case 4:
                setAnswerToButton(wordTrue.getMeanFromWord(),opt4);
                setAnswerToButton(wordFalse1.getMeanFromWord(),opt1);
                setAnswerToButton(wordFalse2.getMeanFromWord(),opt2);
                setAnswerToButton(wordFalse3.getMeanFromWord(),opt3);
        }
        SetQuestion(wordTrue.getWord());
    }
    private boolean checkAnswer(Button button) {
        int q = 0;
        if (button.equals(opt1)) q = 1;
        else if (button.equals(opt2)) q = 2;
        else if (button.equals(opt3)) q = 3;
        else if (button.equals(opt4)) q = 4;

        if (trueAnswer == q) return true;
        return false;
    }
    private int countInt =0;
    private static int correctInt=0 ;

    public static int getCorrectInt() {
        return correctInt;
    }


    @FXML
    AnchorPane anchorPane;
    AnchorPane winAnchorPane;
    private void Win() {
        if (countInt >=10) {
            try {
                winAnchorPane = FXMLLoader.load(getClass().getResource("/FXML/QuizGameResult.fxml"));
                anchorPane.getChildren().clear();
                anchorPane.getChildren().addAll(winAnchorPane);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void opt1clicked(ActionEvent actionEvent) {
        if( checkAnswer(opt1)){
            System.out.println("TRue");
            correctInt++;
        }
        else System.out.println("fasle");
        Win();
        countInt++;
        setCorrect(correctInt);
        setCount(countInt);
        setAll();
    }

    public void opt2clicked(ActionEvent actionEvent) {
        if( checkAnswer(opt2)){
            System.out.println("TRue");
            correctInt++;
        }
        else System.out.println("fasle");
        Win();
        countInt++;
        setCorrect(correctInt);
        setCount(countInt);
        setAll();
    }
    public void opt3clicked(ActionEvent actionEvent) {
        if( checkAnswer(opt3)){
            System.out.println("TRue");
            correctInt++;
        }
        else System.out.println("fasle");
        Win();
        countInt++;
        setCorrect(correctInt);
        setCount(countInt);
        setAll();
    }
    public void opt4clicked(ActionEvent actionEvent) {
        if( checkAnswer(opt4)){
            System.out.println("TRue");
            correctInt++;
        }
        else System.out.println("fasle");
        Win();
        countInt++;
        setCorrect(correctInt);
        setCount(countInt);
        setAll();
    }

}