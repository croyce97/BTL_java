package Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionToSQL {
    private Connection dataBaseLink;
    public Connection DataBaseConnection() {
        String dataBasename = "dictionary";
        String dataBaseUser = "root";
        String passWord = "bachuet123";
        String url = "jdbc:mysql://localhost:3307/" + dataBasename;
        try {

            dataBaseLink = DriverManager.getConnection(url,dataBaseUser,passWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataBaseLink;
    }

}
