package Controller;

import java.util.*;

public class MatchingGame {

    private int turns = 0;
    private int points = 0;
    private final int boardLength = 3;
    private final int boardSize = boardLength * boardLength;
    private final Random random = new Random();

    private String[][] crosswordPairs = {{"Water", "Nước"}, {"Tree", "Cây"}, {"Movie", "Phim ảnh"}, {"Apple", "Quả táo"}};
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

        // xáo trộn ngẫu nhiên
        Collections.shuffle(wordPairs);
        for (int i = 0; i < 10; i++) {
            crosswordPairs[i] = wordPairs.get(i);
        }
    }

    private final ArrayList<String> Options = new ArrayList<>(Arrays.asList(
            crosswordPairs[0][1],crosswordPairs[0][0],
            crosswordPairs[1][1],crosswordPairs[1][0],
            crosswordPairs[2][1],crosswordPairs[2][0],
            crosswordPairs[3][1],crosswordPairs[3][0]));
    private final ArrayList<String> Board = new ArrayList<>(Arrays.asList(
            "","","","","",
            "","","","",""));

    public void setupGame() {
        setupMatchingBoard();
        System.out.println(Board);
    }

    // lấy option tại chỉ số
    public String getOptionAtIndex(int index) {
        return Board.get(index);
    }

    private void setupMatchingBoard() {
        for (int i = 0; i < boardSize - 1; i++) {
            String MatchingOption = Options.get(i);
            int position = random.nextInt(boardSize - 1);

            while (!Objects.equals(Board.get(position), "")) {
                position = random.nextInt(boardSize - 1);
            }
            Board.set(position, MatchingOption);
        }
    }

    public boolean checkTwoPositions(int firstIndex, int secondIndex) {
        for(int i=0;i<10;i++){
            for(int j=0;j<2;j++){
                if((Board.get(firstIndex).equals(crosswordPairs[i][j]))) {
                    if((Board.get(secondIndex)).equals(crosswordPairs[i][0])||
                            (Board.get(secondIndex)).equals(crosswordPairs[i][1])){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
