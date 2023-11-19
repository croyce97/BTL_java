package Controller;

import Data.ConnectionToSQL;
import Data.Data;
import Data.LoadWordFromDataBase;
import Data.Word;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    ListView<Word> wordList;
    @FXML
    TextField textField;
    @FXML
    TextArea t;
    @FXML
    AnchorPane searchAnchorPane;
    AnchorPane search2AnchorPane;
    AnchorPane GameAnchorPane;
    AnchorPane TranslatorAnchorPane;
    AnchorPane AddAnchorPane;
    AnchorPane UpdateAnchorPane;
    AnchorPane DeleteAnchorPane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wordList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        wordList.getItems().clear();
        wordList.getItems().addAll(Data.prefixSearch(""));
        try {
            GameAnchorPane = FXMLLoader.load(getClass().getResource("/FXML/Game.fxml"));
            TranslatorAnchorPane = FXMLLoader.load(getClass().getResource("/FXML/Translator.fxml"));
            AddAnchorPane = FXMLLoader.load(getClass().getResource("/FXML/Add.fxml"));
            UpdateAnchorPane = FXMLLoader.load(getClass().getResource("/FXML/Update.fxml"));
            DeleteAnchorPane = FXMLLoader.load(getClass().getResource("/FXML/Delete.fxml"));
            search2AnchorPane = FXMLLoader.load(getClass().getResource("/FXML/Search.fxml"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void search(ActionEvent e) {
        setMainPane(search2AnchorPane);
    }

    public void wordListClicked(){
        Word word = wordList.getSelectionModel().getSelectedItem();
        t.setText(word.getMean());
    }
    public void inputWordEventHandle(KeyEvent e) {
        wordList.getItems().clear();
        wordList.getItems().addAll(Data.prefixSearch(textField.getText()));
    }
    public void Game(ActionEvent actionEvent) {
        setMainPane(GameAnchorPane);
    }
    public void Translation(ActionEvent actionEvent) {
        setMainPane(TranslatorAnchorPane);
    }
    public void Add(ActionEvent actionEvent) {
        setMainPane(AddAnchorPane);
    }
    public void Update(ActionEvent actionEvent) {
        setMainPane(UpdateAnchorPane);
    }
    public void Delete(ActionEvent actionEvent) {
        setMainPane(DeleteAnchorPane);
    }
    public void Out(ActionEvent actionEvent) {
        Stage getStage = (Stage) searchAnchorPane.getScene().getWindow();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/FXML/start.fxml"));
            Scene Appscene = new Scene(parent);
            getStage.setTitle("Dictionary team Bưởi");
            getStage.setScene(Appscene);
            getStage.centerOnScreen();;
            getStage.show();
        } catch (Exception a) {
            a.printStackTrace();
        }
    }
    public void Speak(ActionEvent actionEvent) {

    }
    public void setMainPane(AnchorPane pane) {
        searchAnchorPane.getChildren().clear();
        searchAnchorPane.getChildren().addAll(pane);
    }

}
