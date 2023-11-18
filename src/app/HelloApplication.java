package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class HelloApplication extends Application {
    public Stage stage;

    @Override
    public void start(Stage PrymaryStage) throws IOException {
        this.stage = PrymaryStage;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/start.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("dictinary team Bưởi");
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(event -> {event.consume();
                CloseRequest(stage);});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void CloseRequest(Stage stage)  {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Stage stageAlert = (Stage) alert.getDialogPane().getScene().getWindow();
        alert.setTitle("Alert");
        alert.setHeaderText("Do you want to exit ?");
        alert.setContentText("Click \"OK\" to exit, click \"Cancel\" to return ");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}