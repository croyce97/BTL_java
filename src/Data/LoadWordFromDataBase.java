package Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoadWordFromDataBase {
    public static ArrayList<Word> List = new ArrayList<>();
    public static void LoadWord() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ConnectionToSQL newConnection = new ConnectionToSQL();
            Connection connectionDB = newConnection.DataBaseConnection();
            String Query = "select * from main";
            if (connectionDB != null) {
                System.out.println("oke \nDang load du lieu tu Database");
            }
            assert connectionDB != null;
            Statement statement = connectionDB.createStatement();
            ResultSet QueryOut = statement.executeQuery(Query);
            while (QueryOut.next()) {
                int idx = QueryOut.getInt(1);
                String word = QueryOut.getString(2);
                String mean = QueryOut.getString(3);
                Word newWord = new Word(idx, word, mean);
                List.add(newWord);

            }
            connectionDB.close();
        } catch (Exception b) {
            b.printStackTrace();
        }

    }

}
