import application.LibraryDatabaseConnection;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseShould {

    @Test
    public void
    connect() {

        LibraryDatabaseConnection ldbc = new LibraryDatabaseConnection();
        ldbc.establishConnection();

        try {
            Statement statement = ldbc.connection.createStatement();
            statement.executeQuery("select current_date;");
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                String currentDate = resultSet.getString(1);
                System.out.println(currentDate);
            }

            statement.executeQuery("select * from LIBRARY.BORROWED_BOOK;");
            resultSet = statement.getResultSet();

            while (resultSet.next()) {
                int borrowed_book_id = resultSet.getInt(1);
                int book_id = resultSet.getInt(2);
                int member_id = resultSet.getInt(3);
                System.out.println(borrowed_book_id + "|" + book_id + "|" + member_id);
            }

        } catch (SQLException SQLex) {
            SQLex.printStackTrace();
        }

        ldbc.terminateConnection();
    }
}
