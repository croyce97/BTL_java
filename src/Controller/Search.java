package Controller;

import Data.Data;
import Data.Word;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Search implements Initializable {
    @FXML
    ListView<Word> wordList;
    @FXML
    TextField textField;
    @FXML
    TextArea t;
    public void initialize(URL location, ResourceBundle resources) {
        wordList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        wordList.getItems().clear();
        wordList.getItems().addAll(Data.prefixSearch(""));
    }
    public void wordListClicked(){
        Word word = wordList.getSelectionModel().getSelectedItem();
        t.setText(word.getMean());
    }
    public void inputWordEventHandle(KeyEvent e) {
        wordList.getItems().clear();
        wordList.getItems().addAll(Data.prefixSearch(textField.getText()));
    }
}
