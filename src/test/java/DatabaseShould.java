import org.junit.Test;

import java.sql.*;
import java.util.Properties;

public class DatabaseShould {

    @Test
    public void
    connect() {

        try {
//            Properties properties = new Properties();
//            properties.setProperty("USER", "dbc");
//            properties.setProperty("PASSWORD", "dbc");
//            properties.setProperty("TMODE", "Teradata");
//            properties.setProperty("CHARSET", "UTF8");
//            properties.setProperty("DATABASE", "EVENTS");

            Connection connection = DriverManager
                    .getConnection("jdbc:teradata://192.168.0.9/TMODE=ANSI,CHARSET=UTF8,DATABASE=EVENTS,USER=dbc,PASSWORD=dbc");

            Statement statement = connection.createStatement();
            statement.executeQuery("select current_date;");
            ResultSet resultSet = statement.getResultSet();

            while ( resultSet.next() ){
                String currentDate = resultSet.getString(1);
                System.out.println(currentDate);
            }


            statement.executeQuery("select * from EVENTS.EVENT_TYPE;");
            resultSet = statement.getResultSet();

            while ( resultSet.next() ){
                int event_type_id = resultSet.getInt(1);
                String event_type_description = resultSet.getString(2);
                int event_category_id = resultSet.getInt(3);
                System.out.println(event_type_id + "|" + event_type_description + "|" + event_category_id);
            }

            connection.close();

        } catch (SQLException SQLex) {
            SQLex.printStackTrace();
        }
    }
}
