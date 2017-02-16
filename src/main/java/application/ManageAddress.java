package application;

import com.neovisionaries.i18n.CountryCode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageAddress {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        ManageAddress MA = new ManageAddress();
        MA.addAddress();

        sessionFactory.close();
    }

    private void addAddress() {
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        for (int i = 0; i < 10; i++) {
            Address newAddress = new Address(0, "first", "town", "city", "postcode", CountryCode.GB.getAlpha3());
            newAddress.setCreateTimestamp(getCurrentTimeStamp());
            newAddress.setModifiedTimestamp(getCurrentTimeStamp());
            System.out.println(newAddress.toString());
            int addressId = (Integer) session.save(newAddress);
            System.out.println("row=" + addressId);
        }

        transaction.commit();
        session.close();
    }

    private static java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }
}
