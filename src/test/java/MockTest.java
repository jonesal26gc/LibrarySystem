import application.*;
import com.neovisionaries.i18n.CountryCode;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.Date;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MockTest {

    // identify that Mockito is working with JUnit.
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private BorrowedBookRepository borrowedBookRepository;

    @Test
    public void
    return_book() {
        Address libraryAddress = new Address(0,"application.Library House", "Upper Tilehouse Street", "", "Hitchin", "Hertfordshire", "UNKNOWN", CountryCode.GB.getAlpha3());

        // for Mock to work, the interface to be overridden must be injected !!
        Library library = new Library("Hitchin application.Library", libraryAddress, borrowedBookRepository);

        Address homeAddress = new Address(0,"Home", "26 Grange Close", "", "Hitchin", "Herfordshire", "SG4 9HD", CountryCode.GB.getAlpha3());

        Member member = new Member("Jones", "Tony", homeAddress, new Date(), Gender.MALE);
        Book book1 = new Book("London Buses", "Fred Bloggs", "v1.1", new Date(), 1.99, BookCategory.NON_FICTION, BookSubject.TRANSPORT);

        // given
        int number =1;
        BorrowedBook b = new BorrowedBook(book1, member);
        b.setNumber(number);
        b.setInDate(new Date());
        b.setActive(false);

        // when
        when(borrowedBookRepository.returnBorrowedBook(b)).thenReturn(b);
        when(borrowedBookRepository.countBooks()).thenReturn(0);
        library.returnBook(b);
        library.obtainBorrowedBookCount();
        library.listBorrowedBooks();

        // then
        verify(borrowedBookRepository, times(1)).returnBorrowedBook(b);
        verify(borrowedBookRepository, times(1)).countBooks();
        verify(borrowedBookRepository, times(1)).listBorrowedBooks();
    }
}
