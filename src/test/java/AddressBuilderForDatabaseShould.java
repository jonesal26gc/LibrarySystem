import application.model.Address;
        import application.LibraryDatabaseConnection;
        import builders.AddressBuilder;
        import org.junit.Test;

        import java.sql.*;

public class AddressBuilderForDatabaseShould {

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

            for (int i = 0; i < 10; i++) {
                Address newAddress = AddressBuilder.anAddress().withStreetNameLine1("").build();

                incrementAddressId(ldbc);
                newAddress.setAddress_id(retrieveAddressId(ldbc));
                newAddress.setCreatedTimestamp(getCurrentTimeStamp());
                newAddress.setModifiedTimestamp(getCurrentTimeStamp());
                System.out.println(newAddress.toString());
                insertAddress(ldbc,newAddress);
            }

            ldbc.connection.commit();

        } catch (SQLException SQLex) {
            SQLex.printStackTrace();
        }

        ldbc.terminateConnection();
    }

    private void insertAddress(LibraryDatabaseConnection ldbc, Address address) throws SQLException {
        PreparedStatement insertStatement = ldbc.connection.prepareStatement(
                "insert " +
                        "into LIBRARY.ADDRESS " +
                        "values (?,?,?,?,?,?,?,?,?,?);"
        );
        insertStatement.setInt(1,address.getAddress_id());
        insertStatement.setString(2,address.getBuildingName());
        insertStatement.setString(3,address.getStreetNameLine1());
        insertStatement.setString(4,address.getStreetNameLine2());
        insertStatement.setString(5,address.getTown());
        insertStatement.setString(6,address.getCity());
        insertStatement.setString(7,address.getPostcode());
        insertStatement.setString(8,address.getCountry());
        insertStatement.setTimestamp(9,address.getCreatedTimestamp());
        insertStatement.setTimestamp(10,address.getModifiedTimestamp());
        insertStatement.execute();
        insertStatement.close();
    }

    private static java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }

    private int retrieveAddressId(LibraryDatabaseConnection ldbc) throws SQLException {
        Statement retrieveStatement = ldbc.connection.createStatement();
        retrieveStatement.executeQuery(
                "select address_id " +
                        "from LIBRARY.address_ID_SEQ;");
        ResultSet resultSet = retrieveStatement.getResultSet();
        if (resultSet.next()) {
            retrieveStatement.close();
            return resultSet.getInt(1);
        } else {
            throw new RuntimeException("cannot get next ADDRESS_ID_SEQ");
        }
    }

    private void incrementAddressId(LibraryDatabaseConnection ldbc) throws SQLException {
        Statement incrementStatement = ldbc.connection.createStatement();
        incrementStatement.execute(
                "update LIBRARY.ADDRESS_ID_SEQ " +
                        "set address_id = (address_id + 1);");
        incrementStatement.close();
    }
}
