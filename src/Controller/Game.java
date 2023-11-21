package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    @FXML
    private GridPane gridPane;

    @FXML
    private Button startButton;

    private String[][] crosswordPairs = new String[10][2];

    @FXML
    private void handleStart() {
        // Load crossword pairs and display them in the grid
        loadCrosswordPairs();
        displayCrosswords();
    }

    private void loadCrosswordPairs() {
        List<String[]> wordPairs = new ArrayList<>(Arrays.asList(
                new String[]{"Water", "Nước"},
                new String[]{"Chair", "Ghế"},
                new String[]{"Tree", "Cây"},
                new String[]{"Book", "Sách"},
                new String[]{"Dog", "Chó"},
                new String[]{"Movie", "Phim ảnh"},
                new String[]{"Car", "Xe hơi"},
                new String[]{"Music", "Nhạc"},
                new String[]{"Apple", "Quả táo"},
                new String[]{"Food", "Thức ăn"}
        ));

        Collections.shuffle(wordPairs);

        for (int i = 0; i < 10; i++) {
            crosswordPairs[i] = wordPairs.get(i);
        }
    }

    private void displayCrosswords() {
        // List to hold all words (both English and Vietnamese)
        List<String> words = new ArrayList<>();

        // Add all words to the list
        for (String[] pair : crosswordPairs) {
            Collections.addAll(words, pair);
        }

        // Shuffle the list to randomize the layout
        Collections.shuffle(words);

        // Calculate the number of rows and columns for the grid
        int numRows = 4; // Example, adjust as needed
        int numCols = 5; // Example, adjust as needed

        // Add buttons to the grid
        for (int i = 0; i < words.size(); i++) {
            Button button = new Button(words.get(i));
            button.setOnAction(event -> handleButtonClick(button));
            int row = i / numCols;
            int col = i % numCols;

            gridPane.add(button, col, row);
        }
    }
    private Button firstButtonClicked = null;
    private String firstWord = null;
    private int firstButtonRow = -1;
    private int firstButtonCol = -1;

    private void handleButtonClick(Button button) {
        String currentWord = button.getText();
        int currentRow = GridPane.getRowIndex(button);
        int currentCol = GridPane.getColumnIndex(button);

        if (firstButtonClicked == null) {
            // This is the first button click
            firstButtonClicked = button;
            firstWord = currentWord;
            firstButtonRow = currentRow;
            firstButtonCol = currentCol;
        } else {
            // This is the second button click
            if (isMatchingPair(firstWord, currentWord) &&
                    (firstButtonRow != currentRow || firstButtonCol != currentCol)) {
                // It's a matching pair and not the same button clicked twice
                removeButton(firstButtonClicked);
                removeButton(button);

                // Reset the first button memory
                resetFirstButtonMemory();
            } else {
                // Not a matching pair or same button clicked twice, reset memory
                resetFirstButtonMemory();
            }
        }
    }

    private boolean isMatchingPair(String word1, String word2) {
        // Check if the words are a matching pair
        for (String[] pair : crosswordPairs) {
            if ((pair[0].equals(word1) && pair[1].equals(word2)) ||
                    (pair[0].equals(word2) && pair[1].equals(word1))) {
                return true;
            }
        }
        return false;
    }

    private void removeButton(Button button) {
        gridPane.getChildren().remove(button);
    }

    private void resetFirstButtonMemory() {
        firstButtonClicked = null;
        firstWord = null;
        firstButtonRow = -1;
        firstButtonCol = -1;
    }
}





