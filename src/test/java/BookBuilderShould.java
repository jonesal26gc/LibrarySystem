import application.LibraryHibernateConnection;
import application.enumerators.BookCategory;
import application.enumerators.BookSubject;
import application.model.Book;

import builders.BookBuilder;
import org.junit.Test;

import java.util.Date;

public class BookBuilderShould {

    @Test
    public void
    build_me_a_book() {


        LibraryHibernateConnection lhc = new LibraryHibernateConnection();
        lhc.open();
        lhc.startTransaction();

        for (int i = 0; i < 10; i++) {

            Book newBook = BookBuilder.aBook()
                    .withBook_id(0)
                    .withTitle("Java Programming for Idiots - Part " + i)
                    .withAuthor("Tony Jones")
                    .withCostPrice(0.99)
                    .withPublicationDate(new Date())
                    .withPublicationVersion("v1.0")
                    .withBookCategoryId(BookCategory.NON_FICTION.getBookCategoryId())
                    .withBookSubjectId(BookSubject.UNKNOWN.getBookSubjectId())
                    .build();
            newBook.setCreatedTimestamp(lhc.getCurrentTimeStamp());
            System.out.println(newBook.toString());
            int bookId = (Integer) lhc.session.save(newBook);
            System.out.println("row=" + bookId);
        }

        lhc.endTransaction();
        lhc.close();
    }
}
