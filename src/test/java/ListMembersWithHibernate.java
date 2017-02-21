import application.LibraryHibernateConnection;
import application.model.Book;
import application.model.Member;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class ListMembersWithHibernate {


    @Test
    public void
    list_members() {

        LibraryHibernateConnection lhc = new LibraryHibernateConnection();
        lhc.open();
        lhc.startTransaction();

        Query enquiryQuery = lhc.session.createQuery("from Member where member_id = :p1");
        enquiryQuery.setInteger("p1", 7);
        List list = enquiryQuery.list();

        for (Object object : list) {
            Member member = (Member) object;
            System.out.println(member.getForename() + " " + member.getSurname());

            if (member.getSurname().equals("Menzies")) {
                Query updateQuery = lhc.session.createQuery(
                        "update Member" +
                                " set surname = :surname" +
                                " where member_id = :p1");
                updateQuery.setString("surname", "Jones");
                updateQuery.setInteger("p1", 7);
                int rc = updateQuery.executeUpdate();
                System.out.println("RC=" + rc);
            }
        }

        Query deleteQuery = lhc.session.createQuery(
                "delete from Member" +
                        " where surname = :surname");
        deleteQuery.setString("surname", "Jones");
        System.out.println("RC=" + deleteQuery.executeUpdate());


        Query sumQuery = lhc.session.createQuery("select count(*) from Member");
        List<Integer> sumList = sumQuery.list();
        Iterator<Integer> iter = sumList.iterator();
        while (iter.hasNext()) {
            System.out.println("there are " + iter.next() + " rows");
        }


        Criteria selectWithCriteria = lhc.session.createCriteria(Member.class);
        selectWithCriteria.addOrder(Order.asc("surname"));
        selectWithCriteria.addOrder(Order.asc("forename"));
        selectWithCriteria.add(Restrictions.between("member_id", 10, 15));

        // Include only specific fields.
        selectWithCriteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("surname"))
                        .add(Projections.property("forename"))
                        .add(Projections.property("address")));

        List<Object> selectWithCriteriaOutput = selectWithCriteria.list();
        System.out.println("with criteria");
        for (Object row : selectWithCriteriaOutput) {
            //System.out.println(o.getClass());
            Object[] column = (Object[]) row;
            //System.out.println(column.length);
            System.out.println(column[0].toString() + "," + column[1].toString());
            System.out.println(column[2].toString());
        }

        Query namedQuery1 = lhc.session.getNamedQuery("cheapBooks");
        List<Book> cheapBooksList = namedQuery1.list();
        for (Book cheapBook : cheapBooksList) {
            System.out.println(cheapBook.getTitle() + " @ " + cheapBook.getCostPrice());
        }








        lhc.endTransaction();
        lhc.close();
    }
}
