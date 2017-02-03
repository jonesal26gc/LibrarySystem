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
        Address libraryAddress = new Address("Library House", "Upper Tilehouse Street", "", "Hitchin", "Hertfordshire", "UNKNOWN", Country.UNITED_KINGDOM);

        // for Mock to work, the interface to be overridden must be injected !!
        Library library = new Library("Hitchin Library", libraryAddress, borrowedBookRepository);

        Address homeAddress = new Address("Home", "26 Grange Close", "", "Hitchin", "Herfordshire", "SG4 9HD", Country.UNITED_KINGDOM);

        Member member = new Member("Jones", "Tony", homeAddress, new Date(), Gender.MALE);
        Book book1 = new Book("London Buses", "Fred Bloggs", "v1.1", new Date(), 1.99, BookCategory.NON_FICTION, BookSubject.TRANSPORT);

        // given
        int number =1;
        BorrowedBook b = new BorrowedBook(book1, member);
        b.setNumber(number);
        b.setInDate(new Date());
        b.setActive(false);

        // when
        when(borrowedBookRepository.returnBook(number)).thenReturn(b);
        when(borrowedBookRepository.countBooks()).thenReturn(0);
        library.returnBook(number);
        library.obtainBorrowedBookCount();
        library.listBorrowedBooks();

        // then
        verify(borrowedBookRepository, times(1)).returnBook(b.getNumber());
        verify(borrowedBookRepository, times(1)).countBooks();
        verify(borrowedBookRepository, times(1)).listBorrowedBooks();
    }
}
