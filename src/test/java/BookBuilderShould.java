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

        Book newBook = BookBuilder.aBook()
                .withBook_id(0)
                .withTitle("Java Programming for Idiots")
                .withAuthor("Tony Jones")
                .withCostPrice(0.99)
                .withPublicationDate(new Date())
                .withPublicationVersion("v1.0")
                .withBookCategoryCode(BookCategory.NON_FICTION.getBookCategoryCode())
                .withBookSubjectCode(BookSubject.UNKNOWN.getBookSubjectCode())
                .build();

        System.out.println(newBook.toString());

    }
}
