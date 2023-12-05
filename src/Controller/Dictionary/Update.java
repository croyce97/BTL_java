package Controller.Dictionary;

import Data.Data;
import Data.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Update implements Initializable {
    @FXML
    ListView<Word> wordList;
    @FXML
    TextField textField;
    @FXML
    TextArea t;
    @FXML
    TextField UpdateMean;
    @FXML
    Text textOke;
    Word word;
    public void initialize(URL location, ResourceBundle resources) {
        wordList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        wordList.getItems().clear();
        wordList.getItems().addAll(Data.prefixSearch(""));
    }
    public void wordListClicked(){
        word = wordList.getSelectionModel().getSelectedItem();
        t.setText(word.getMean());
    }
    public void inputWordEventHandle(KeyEvent e) {
        wordList.getItems().clear();
        wordList.getItems().addAll(Data.prefixSearch(textField.getText()));
    }
    public void update(ActionEvent actionEvent) {
        if (word == null) {
            textOke.setText("chua chon tu");
            return;
        }
        Word newWord = new Word(word.getIdx(), word.getWord(), UpdateMean.getText());
        Data.Update(newWord);
        textOke.setText("tu da duoc update");
    }

}