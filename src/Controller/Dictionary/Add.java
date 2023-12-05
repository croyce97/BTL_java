package Controller.Dictionary;

import Data.Data;
import Data.Word;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;


public class Add {
    @FXML
    TextField Wordin;
    @FXML
    TextField Classs;
    @FXML
    TextField Pronoun;
    @FXML
    TextField Definition;
    @FXML
    Text WordError;
    @FXML
    Text ClassError;
    @FXML
    Text PronounError;
    @FXML
    Text DefinitionError;
    @FXML
    Text oke;
    public void OkeAndAdd(ActionEvent actionEvent) {
        String word = Wordin.getText();
        String classs = Classs.getText();
        String pronoun = Pronoun.getText();
        String definition = Definition.getText();
        if (word.isEmpty() || classs.isEmpty() || pronoun.isEmpty()|| definition.isEmpty()) {
            if (word.isEmpty()) {
                WordError.setText("Error");
            } else WordError.setText("");

            if (classs.isEmpty()) {
                ClassError.setText("Error");
            } else ClassError.setText("");

            if (pronoun.isEmpty()) {
                PronounError.setText("Error");
            } else PronounError.setText("");

            if (definition.isEmpty()) {
                DefinitionError.setText("Error");
            } else DefinitionError.setText("");
            oke.setText("tu chua duoc them");
        }
        else {
            String mean = word + " / " + pronoun + " / \n" + classs + '\n' + definition ;
            Word word1 = new Word(Data.idxMax,word,mean);
            Data.Add(word1);
            oke.setText("tu da duoc them");
        }
    }
    public void inputWordEventHandle1(KeyEvent e) {
        WordError.setText("");
    }
    public void inputWordEventHandle2(KeyEvent e) {
        ClassError.setText("");
    }
    public void inputWordEventHandle3(KeyEvent e) {
        PronounError.setText("");
    }
    public void inputWordEventHandle4(KeyEvent e) {
        DefinitionError.setText("");
    }

}
