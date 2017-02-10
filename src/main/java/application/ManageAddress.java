package application;

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
        Integer addressId = MA.addAddress();
        System.out.println("row=" + addressId);

        sessionFactory.close();
    }

    private Integer addAddress() {
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Address newAddress = new Address("name", "first", "second", "town", "city", "postcode", Country.UNITED_KINGDOM);
        newAddress.setCreateTimestamp(getCurrentTimeStamp());
        newAddress.setModifiedTimestamp(getCurrentTimeStamp());
        int addressId = (Integer) session.save(newAddress);

        transaction.commit();
        session.close();

        return addressId;
    }

    private static java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }
}
