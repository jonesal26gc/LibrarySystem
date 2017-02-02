import org.junit.Test;

import java.sql.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibraryShould {

    @Test
    public void
    enroll_new_member(){
        // given
        Address address = new Address("Home","26 Grange Close","","Hitchin","Herfordshire","SG4 9HD",Country.UNITED_KINGDOM);
        Customer customer = new Customer("Jones","Tony", address, Date.valueOf("1962-09-22"));
        Library library = new Library("Hitchin Library", address);

        // when
        library.enroll(customer);

        // then
        assertThat(library.findNumberOfMembers(),is(1));
        library.getMemberShip().addCustomer(customer);
        library.getMemberShip().listCustomerIdAndNames();

    }
}
