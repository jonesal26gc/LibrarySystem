import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class LibraryShould {
    // identify that Mockito is working with JUnit.
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    BorrowedBookRepository borrowedBookRepository;

    private Address libraryAddress = new Address("Library House", "Upper Tilehouse Street", "", "Hitchin", "Hertfordshire", "UNKNOWN", Country.UNITED_KINGDOM);
    private Library library = new Library("Hitchin Library", libraryAddress, borrowedBookRepository);

    private Address homeAddress = new Address("Home", "26 Grange Close", "", "Hitchin", "Hertfordshire", "SG4 9HD", Country.UNITED_KINGDOM);

    private Member member = new Member("Jones", "Tony", homeAddress, new Date(), Gender.MALE);
    private Book book1 = new Book("London Buses", "Fred Bloggs", "v1.1", new Date(), 1.99, BookCategory.NON_FICTION, BookSubject.TRANSPORT);

    private Book book2 = new Book("More On Buses", "Simon Trigg", "v1.1", new Date(), 10.99, BookCategory.NON_FICTION, BookSubject.TRANSPORT);

    @Before
    public void stuff_before_tests() {
    }

    @Test
    public void
    register_member() {
        // given

        // when
        library.registerMember(member);

        // then
        assertThat(library.obtainMemberCount(), is(1));
        library.listMembers();
    }

    @Test
    public void
    add_book_to_library() {
        library.insertBookIntoCatalogue(book1);
        library.insertBookIntoCatalogue(book2);
        assertThat(library.obtainBookCount(), is(2));
        library.listBooks();
    }

    @Test
    public void
    borrow_book() {
        // given
        library.registerMember(member);
        library.insertBookIntoCatalogue(book1);

        // when
        int reference = library.borrowBook(book1, member).getNumber();

        // then
        assertThat(library.obtainBorrowedBookCount(), is(1));
        library.listBorrowedBooks();
    }

    @Test
    public void
    return_book() {
        // given
        library.registerMember(member);
        library.insertBookIntoCatalogue(book1);
        int reference = library.borrowBook(book1, member).getNumber();
        assertThat(library.obtainBorrowedBookCount(), is(1));
        //library.listBorrowedBooks();

        // when
        library.returnBook(reference);

        // then
        assertThat(library.obtainBorrowedBookCount(), is(0));
        library.listBorrowedBooks();
    }
}
