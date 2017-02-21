import application.LibraryHibernateConnection;
import application.model.Book;
import org.hibernate.Query;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class NamedQueriesWithHibernateShould {

    @Test
    public void
    list_the_cheap_books() {

        LibraryHibernateConnection lhc = new LibraryHibernateConnection();
        lhc.open();
        lhc.startTransaction();

        Query namedQuery1 = lhc.session.getNamedQuery("cheapBooks");
        namedQuery1.setDouble("costPrice",1.00);
        List<Book> cheapBooksList = namedQuery1.list();
        for (Book cheapBook : cheapBooksList) {
            System.out.println(cheapBook.getTitle() + " @ " + cheapBook.getCostPrice());
        }

        lhc.endTransaction();
        lhc.close();
    }

    @Test
    public void
    count_the_cheap_books() {

        LibraryHibernateConnection lhc = new LibraryHibernateConnection();
        lhc.open();
        lhc.startTransaction();

        Query namedNativeQuery1 = lhc.session.getNamedQuery("countBooks");
        namedNativeQuery1.setDouble("costPrice",1.00);
        List<BigDecimal> cheapBooksCountList = namedNativeQuery1.list();
        for (BigDecimal cheapBook : cheapBooksCountList) {
            System.out.println("count=" + cheapBook);
        }

        lhc.endTransaction();
        lhc.close();
    }

    @Test
    public void
    list_the_last_book() {

        LibraryHibernateConnection lhc = new LibraryHibernateConnection();
        lhc.open();
        lhc.startTransaction();

        Query namedNativeQuery = lhc.session.getNamedQuery("lastBook");
        List<Integer> cheapBooksCountList = namedNativeQuery.list();
        for (Integer lastBook : cheapBooksCountList) {
            System.out.println("book_id=" + lastBook);
        }

        lhc.endTransaction();
        lhc.close();
    }
}
