import application.*;
import org.junit.Test;

import java.util.Date;

public class BorrowedBookDatabaseShould {

    @Test
    public void
    count_books(){

        LibraryDatabaseConnection ldbc = new LibraryDatabaseConnection();
        ldbc.establishConnection();

        BorrowedBookDatabase borrowedBookDatabase = new BorrowedBookDatabase(ldbc);
        System.out.println("Borrowed Books=" + borrowedBookDatabase.countBooks());

        borrowedBookDatabase.listBorrowedBooks();

        ldbc.terminateConnection();
    }


    @Test
    public void
    insert_borrowed_books(){

        LibraryDatabaseConnection ldbc = new LibraryDatabaseConnection();
        ldbc.establishConnection();

        BorrowedBookDatabase borrowedBookDatabase = new BorrowedBookDatabase(ldbc);

        Member member = new Member("Jones", "Tony", null, new Date(), Gender.MALE);
        Book book1 = new Book("London Buses", "Fred Bloggs", "v1.1", new Date(), 1.99, BookCategory.NON_FICTION, BookSubject.TRANSPORT);

        BorrowedBook bb = new BorrowedBook(book1,member);
        borrowedBookDatabase.insertBorrowedBook(bb);
        System.out.println(bb.toString());

        System.out.println("Borrowed Books=" + borrowedBookDatabase.countBooks());

        borrowedBookDatabase.listBorrowedBooks();

        ldbc.terminateConnection();
    }


    @Test
    public void
    return_borrowed_book(){

        LibraryDatabaseConnection ldbc = new LibraryDatabaseConnection();
        ldbc.establishConnection();

        BorrowedBookDatabase borrowedBookDatabase = new BorrowedBookDatabase(ldbc);

        Member member = new Member("Jones", "Tony", null, new Date(), Gender.MALE);
        Book book1 = new Book("London Buses", "Fred Bloggs", "v1.1", new Date(), 1.99, BookCategory.NON_FICTION, BookSubject.TRANSPORT);

        BorrowedBook bb = new BorrowedBook(book1,member);
        bb.setNumber(12);
        borrowedBookDatabase.returnBorrowedBook(bb);
        System.out.println(bb.toString());

        System.out.println("Borrowed Books=" + borrowedBookDatabase.countBooks());

        borrowedBookDatabase.listBorrowedBooks();

        ldbc.terminateConnection();
    }
}
