package Controller.Dictionary;

import Data.Data;
import Data.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Delete implements Initializable {
    @FXML
    TextField textField;
    @FXML
    ListView<Word> wordList;
    @FXML
    Text textOke;
    private Word word;
    public void initialize(URL location, ResourceBundle resources) {
        wordList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        wordList.getItems().clear();
        wordList.getItems().addAll(Data.prefixSearch(""));
    }
    public void wordListClicked(){
        word = wordList.getSelectionModel().getSelectedItem();
        System.out.println(word.getWord());
    }
    public void inputWordEventHandle(KeyEvent e) {
        wordList.getItems().clear();
        wordList.getItems().addAll(Data.prefixSearch(textField.getText()));
    }
    public void DeleteButton(ActionEvent actionEvent) {
        if (word == null) {
            textOke.setText("chua chon tu de xoa");
            return;
        }
        textOke.setText(" tu da duoc xoa");
        Data.Delete(word);
    }
}
