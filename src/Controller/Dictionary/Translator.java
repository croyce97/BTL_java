package Controller.Dictionary;

import API.Language;
import API.TranslatorGG;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;

public class Translator implements Initializable {
    @FXML
    TextField needTrans;
    @FXML
    TextField Transed;
    @FXML
    ChoiceBox<String> langFrom;
    @FXML
    ChoiceBox<String> langTo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Set set = Language.Lang.keySet();
        for (Object key : set) {
            String s = (String) key;
            langFrom.getItems().add(s);
            langTo.getItems().add(s);
        }
        langFrom.setValue("Tiếng Anh");
        langTo.setValue("Tiếng Việt");
    }

    public void Trans(ActionEvent actionEvent) throws IOException {
        String langFormm = Language.Lang.get(langFrom.getValue());
        String langToo = Language.Lang.get(langTo.getValue());
        String trans = TranslatorGG.translate(langFormm, langToo ,needTrans.getText());
        Transed.setText(trans);
    }
}
