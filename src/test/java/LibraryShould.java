import application.*;
import application.model.Address;
import application.model.Member;
import com.neovisionaries.i18n.CountryCode;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibraryShould {

    private Address libraryAddress = new Address(0, "Upper Tilehouse Street", "Hitchin", "Hertfordshire", "UNKNOWN", CountryCode.GB.getAlpha3());
    private Library library = new Library("Hitchin application.Library", libraryAddress, new BorrowedBookRegister());

    private Address homeAddress = new Address(0, "26 Grange Close", "Hitchin", "Hertfordshire", "SG4 9HD", CountryCode.GB.getAlpha3());

    private Member member = new Member(0,"Jones", "Tony", homeAddress, new Date(), Gender.MALE.getGenderCode());
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
        BorrowedBook b = library.borrowBook(book1, member);
        assertThat(library.obtainBorrowedBookCount(), is(1));
        //library.listBorrowedBooks();

        // when
        library.returnBook(b);

        // then
        assertThat(library.obtainBorrowedBookCount(), is(0));
        library.listBorrowedBooks();
    }
}
