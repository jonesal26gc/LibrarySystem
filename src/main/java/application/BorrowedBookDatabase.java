package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class BorrowedBookDatabase implements BorrowedBookRepository {
    private LibraryDatabaseConnection ldbc;

    public BorrowedBookDatabase(LibraryDatabaseConnection ldbc) {
        this.ldbc = ldbc;
    }

    public BorrowedBook insertBorrowedBook(BorrowedBook borrowedBook) {
        try {
            incrementBorrowedBookId();
            borrowedBook.setNumber(retrieveBorrowedBookId());
            insertBorrowedBookRow(borrowedBook);
        } catch (SQLException SQLex) {
            SQLex.printStackTrace();
        }
        return borrowedBook;
    }

    private void incrementBorrowedBookId() throws SQLException {
        Statement statement = ldbc.connection.createStatement();
        statement.execute(
                "update LIBRARY.BORROWED_BOOK_ID_SEQ " +
                        "set borrowed_book_id = (borrowed_book_id + 1);");
    }

    private int retrieveBorrowedBookId() throws SQLException {
        Statement statement = ldbc.connection.createStatement();
        statement.executeQuery(
                "select borrowed_book_id " +
                        "from LIBRARY.BORROWED_BOOK_ID_SEQ;");
        ResultSet resultSet = statement.getResultSet();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            throw new RuntimeException("cannot get the next sequence number");
        }
    }

    private void insertBorrowedBookRow(BorrowedBook borrowedBook) throws SQLException {
        PreparedStatement preparedStatement = ldbc.connection.prepareStatement(
                "INSERT " +
                        "INTO LIBRARY.BORROWED_BOOK " +
                        "(borrowed_book_id, book_id, member_id, active, out_date) " +
                        "values (?,?,?,?,current_date);");
        preparedStatement.setInt(1, borrowedBook.getNumber());
        preparedStatement.setInt(2, borrowedBook.getBookNumber());
        preparedStatement.setInt(3, borrowedBook.getMemberNumber());
        if (borrowedBook.isActive()) {
            preparedStatement.setByte(4, (byte) 1);
        } else {
            preparedStatement.setByte(4, (byte) 0);
        }
        preparedStatement.execute();
    }

    public void listBorrowedBooks() {
        try {
            Statement statement = ldbc.connection.createStatement();
            statement.executeQuery(
                    "select * " +
                            "from LIBRARY.BORROWED_BOOK;");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int borrowed_book_id = resultSet.getInt(1);
                System.out.println(borrowed_book_id);
            }
        } catch (SQLException SQLex) {
            SQLex.printStackTrace();
        }
    }

    public BorrowedBook returnBorrowedBook(BorrowedBook borrowedBook) {
        borrowedBook.setActive(false);
        borrowedBook.setInDate(new Date());
        try {
            updateBorrowedBookRow(borrowedBook);
        } catch (SQLException SQLex) {
            SQLex.printStackTrace();
        }
        return borrowedBook;
    }

    private void updateBorrowedBookRow(BorrowedBook borrowedBook) throws SQLException {
        PreparedStatement preparedStatement = ldbc.connection.prepareStatement(
                "UPDATE " +
                        "LIBRARY.BORROWED_BOOK " +
                        "set active = ?" +
                        "  , out_date = current_date " +
                        "where borrowed_book_id = ? ;");
        if (borrowedBook.isActive()) {
            preparedStatement.setByte(1, (byte) 1);
        } else {
            preparedStatement.setByte(1, (byte) 0);
        }
        preparedStatement.setInt(2, borrowedBook.getNumber());
        preparedStatement.execute();
    }

    public int countBooks() {
        try {
            Statement statement = ldbc.connection.createStatement();
            statement.executeQuery(
                    "select" +
                            " count(*) " +
                            "from LIBRARY.BORROWED_BOOK;");
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException SQLex) {
            SQLex.printStackTrace();
        }
        return 0;
    }
}
