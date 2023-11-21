package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateSQL {
    public static void Add(Word word) {
        ConnectionToSQL newConnection = new ConnectionToSQL();

        Connection connectionDB = newConnection.DataBaseConnection();
        String sql = " insert into main (id, word,meaning)"
                + " values (?, ?, ?)";
        try {
            if (connectionDB != null) {
                System.out.println("oke co the them tu");
            }
            assert connectionDB != null;

            PreparedStatement preparedStmt = connectionDB.prepareStatement(sql);
            preparedStmt.setInt(1, word.getIdx());
            preparedStmt.setString(2, word.getWord());
            preparedStmt.setString(3, word.getMean());

            boolean a = preparedStmt.execute();
            if (!a) {
                System.out.println("tu da duoc them");

            }
            else System.out.println("khogn them dc tu");
            connectionDB.close();
        } catch (Exception b) {
            System.err.println("Got an exception!");
            b.printStackTrace();
        }
    }
    public static void UpdateWord(Word word) {
        ConnectionToSQL newConnection = new ConnectionToSQL();

        Connection connectionDB = newConnection.DataBaseConnection();
        String sql = " UPDATE main SET meaning = ? WHERE id = ?;";
        try {
            if (connectionDB != null) {
                System.out.println("oke co the sua tu");
            }
            assert connectionDB != null;

            PreparedStatement preparedStmt = connectionDB.prepareStatement(sql);
            preparedStmt.setString(1, word.getMean());
            preparedStmt.setInt(2, word.getIdx());


            boolean a = preparedStmt.execute();
            if (!a) {
                System.out.println("tu da duoc xoa");

            }
            else System.out.println("khogn xoa dc tu");
            connectionDB.close();
        } catch (Exception b) {
            System.err.println("Got an exception!");
            b.printStackTrace();
        }

    }
    public static void DeleteWord(Word word) {
        ConnectionToSQL newConnection = new ConnectionToSQL();

        Connection connectionDB = newConnection.DataBaseConnection();
        String sql = " DELETE FROM main WHERE id = ?;";
        try {
            if (connectionDB != null) {
                System.out.println("oke co the xoa tu");
            }
            assert connectionDB != null;

            PreparedStatement preparedStmt = connectionDB.prepareStatement(sql);
            preparedStmt.setInt(1, word.getIdx());

            boolean a = preparedStmt.execute();
            if (!a) {
                System.out.println("tu da duoc xoa");

            }
            else System.out.println("khong xoa dc tu");
            connectionDB.close();
        } catch (Exception b) {
            System.err.println("Got an exception!");
            b.printStackTrace();
        }
    }

}
