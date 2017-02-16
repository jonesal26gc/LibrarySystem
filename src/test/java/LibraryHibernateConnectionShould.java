import application.model.Address;
import application.LibraryHibernateConnection;
import application.model.Member;
import builders.AddressBuilder;
import builders.MemberBuilder;
import org.junit.Test;

public class LibraryHibernateConnectionShould {

    @Test
    public void
    make_connection(){

        LibraryHibernateConnection lhc = new LibraryHibernateConnection();
        lhc.open();
        lhc.startTransaction();

        for (int i = 0; i < 10; i++) {
            Address newAddress = AddressBuilder.anAddress().withStreetNameLine1("").build();
            newAddress.setCreatedTimestamp(lhc.getCurrentTimeStamp());
            System.out.println(newAddress.toString());

            Member newMember = MemberBuilder.aMember().withSurname("").withAddress(newAddress).build();
            System.out.println(newMember.toString());

            int memberId = (Integer) lhc.session.save(newMember);
            System.out.println("row=" + memberId);
        }

        lhc.endTransaction();
        lhc.close();
    }


}
