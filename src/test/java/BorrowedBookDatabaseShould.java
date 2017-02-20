import application.*;
import application.enumerators.BookCategory;
import application.enumerators.BookSubject;
import application.enumerators.Gender;
import application.model.Book;
import application.model.BorrowedBook;
import application.model.Member;
import org.junit.Test;

import java.util.Date;

public class BorrowedBookDatabaseShould {

    @Test
    public void
    count_books(){

        LibraryDatabaseConnection ldbc = new LibraryDatabaseConnection();
        ldbc.establishConnection();

        BorrowedBookTable borrowedBookDatabaseTable = new BorrowedBookTable(ldbc);
        System.out.println("Borrowed Books=" + borrowedBookDatabaseTable.countBooks());

        borrowedBookDatabaseTable.listBorrowedBooks();

        ldbc.terminateConnection();
    }


    @Test
    public void
    insert_borrowed_books(){

        LibraryDatabaseConnection ldbc = new LibraryDatabaseConnection();
        ldbc.establishConnection();

        BorrowedBookTable borrowedBookDatabaseTable = new BorrowedBookTable(ldbc);

        Member member = new Member(0,"Jones", "Tony", null, new Date(), Gender.MALE.name());
        Book book1 = new Book(0,"London Buses", "Fred Bloggs", "v1.1", new Date(), 1.99, BookCategory.NON_FICTION.getBookCategoryId(), BookSubject.TRANSPORT.getBookSubjectId());

        BorrowedBook bb = new BorrowedBook(0,book1,member,new Date());
        borrowedBookDatabaseTable.insertBorrowedBook(bb);
        System.out.println(bb.toString());

        System.out.println("Borrowed Books=" + borrowedBookDatabaseTable.countBooks());

        borrowedBookDatabaseTable.listBorrowedBooks();

        ldbc.terminateConnection();
    }


    @Test
    public void
    return_borrowed_book(){

        LibraryDatabaseConnection ldbc = new LibraryDatabaseConnection();
        ldbc.establishConnection();

        BorrowedBookTable borrowedBookDatabaseTable = new BorrowedBookTable(ldbc);

        Member member = new Member(0,"Jones", "Tony", null, new Date(), Gender.MALE.name());
        Book book1 = new Book(0,"London Buses", "Fred Bloggs", "v1.1", new Date(), 1.99, BookCategory.NON_FICTION.getBookCategoryId(), BookSubject.TRANSPORT.getBookSubjectId());

        BorrowedBook bb = new BorrowedBook(0,book1,member, new Date());
        bb.setBorrowedBookId(12);
        borrowedBookDatabaseTable.returnBorrowedBook(bb);
        System.out.println(bb.toString());

        System.out.println("Borrowed Books=" + borrowedBookDatabaseTable.countBooks());

        borrowedBookDatabaseTable.listBorrowedBooks();

        ldbc.terminateConnection();
    }
}
