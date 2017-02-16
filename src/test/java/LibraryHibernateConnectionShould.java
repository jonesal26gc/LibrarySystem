import application.Address;
import application.LibraryHibernateConnection;
import com.neovisionaries.i18n.CountryCode;
import org.junit.Test;

public class LibraryHibernateConnectionShould {

    @Test
    public void
    make_connection(){

        LibraryHibernateConnection lhc = new LibraryHibernateConnection();
        lhc.open();
        lhc.startTransaction();

        for (int i = 0; i < 10; i++) {
            Address newAddress = new Address(0, "first", "town", "city", "postcode", CountryCode.GB.getAlpha3());
            newAddress.setCreateTimestamp(lhc.getCurrentTimeStamp());
            System.out.println(newAddress.toString());
            int addressId = (Integer) lhc.session.save(newAddress);
            System.out.println("row=" + addressId);
        }

        lhc.endTransaction();
        lhc.close();
    }


}
