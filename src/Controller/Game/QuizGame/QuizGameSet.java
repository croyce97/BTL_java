package Controller.Game.QuizGame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.util.List;


public class QuizGameSet {
    private List<String> questions;
    private List<String[]> options;
    private List<String> correctAnswers;

    public QuizGameSet(List<String> questions, List<String[]> options, List<String> correctAnswers) {
        this.questions = questions;
        this.options = options;
        this.correctAnswers = correctAnswers;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public List<String[]> getOptions() {
        return options;
    }

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }


}
