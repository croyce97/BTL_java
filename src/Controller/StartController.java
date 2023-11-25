package Controller;

import Data.ConnectionToSQL;
import Data.LoadWordFromDataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class StartController {
    @FXML
    private AnchorPane startAnchorPane;

    @FXML
    protected void Start(ActionEvent e) {
        Stage getStage = (Stage) startAnchorPane.getScene().getWindow();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/FXML/mainApp.fxml"));
            Scene Appscene = new Scene(parent);
            getStage.setTitle("Dictionary team Bưởi");
            getStage.setScene(Appscene);
            getStage.centerOnScreen();;
            getStage.show();
        } catch (Exception a) {
            a.printStackTrace();
        }

    }
    @FXML
    protected  void Out(ActionEvent e) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
        alert.setTitle("Alert");
        alert.setHeaderText("Do you want to exit ?");
        alert.setContentText("Click \"OK\" to exit, click \"Cancel\" to return ");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.exit(0);
        }
    }
}
