package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LibraryDatabaseConnection {
    public Connection connection;

    public LibraryDatabaseConnection() {
    }

    public void establishConnection() {
        try {
            connection = DriverManager
                    .getConnection("jdbc:teradata://192.168.1.10/" +
                            "TMODE=ANSI," +
                            "CHARSET=UTF8," +
                            "DATABASE=LIBRARY," +
                            "USER=dbc," +
                            "PASSWORD=dbc");
        } catch (SQLException SQLex) {
            SQLex.printStackTrace();
        }
    }

    public void terminateConnection() {
        try {
            connection.close();
        } catch (SQLException SQLex) {
            SQLex.printStackTrace();
        }
    }
}
