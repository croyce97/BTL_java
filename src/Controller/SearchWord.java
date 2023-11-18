package Controller;

import Data.Data;
import Data.Word;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TextArea;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;


public class SearchWord implements Initializable {

    @FXML
    TextField textField;
    @FXML
    ListView<Word> wordList;
    @FXML
    TextArea textArea;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wordList.getItems().clear();
        wordList.getItems().addAll(Data.prefixSearch("a"));
    }

}
