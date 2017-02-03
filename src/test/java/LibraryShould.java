import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibraryShould {
    private Address libraryAddress = new Address("Library House", "Upper Tilehouse Street", "", "Hitchin", "Hertfordshire", "UNKNOWN", Country.UNITED_KINGDOM);
    private Library library = new Library("Hitchin Library", libraryAddress);

    private Address homeAddress = new Address("Home", "26 Grange Close", "", "Hitchin", "Herfordshire", "SG4 9HD", Country.UNITED_KINGDOM);
    private Customer customer = new Customer("Jones", "Tony", homeAddress, Date.valueOf("1962-09-22"), Gender.MALE);

    private Book busBook = new Book("London Buses","Fred Bloggs","v1.1", Date.valueOf("2000-01-01"),1.99,BookCategory.NON_FICTION,BookSubject.TRANSPORT);

    @Before
    public void stuff_before_tests() {

    }

    @Test
    public void
    enroll_new_member() {
        // given

        // when
        library.enroll(customer);

        // then
        assertThat(library.findNumberOfMembers(), is(1));
        library.listCustomers();
    }

    @Test
    public void
    add_book_to_library_catalogue(){
        library.addBookToCatalogue(busBook);
        assertThat(library.findNumberOfBooks(), is(1));
        library.listBooks();
    }


    @Test
    public void
    borrow_book_from_library(){
        // given
        library.enroll(customer);
        library.addBookToCatalogue(busBook);

        // when
        library.borrowBook(customer,busBook);

        // then

    }
}
