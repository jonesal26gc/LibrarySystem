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

        Query namedQuery = lhc.session.getNamedQuery("cheapBooks");
        namedQuery.setDouble("cost_price",1.00);
        List<Book> cheapBooksList = namedQuery.list();
        for (Book cheapBook : cheapBooksList) {
            System.out.println(cheapBook.getBook_id() + " is " + cheapBook.getTitle() + " @ " + cheapBook.getCostPrice());
        }

        lhc.endTransaction();
        lhc.close();
    }

    @Test
    public void
    list_the_expensive_books() {

        LibraryHibernateConnection lhc = new LibraryHibernateConnection();
        lhc.open();
        lhc.startTransaction();

        Query namedQuery = lhc.session.getNamedQuery("expensiveBooks");
        namedQuery.setDouble("cost_price",0.98);
        List<Double> expensiveBooks = namedQuery.list();
        for (Double expensiveBook : expensiveBooks) {
            System.out.println(expensiveBook.toString());
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
