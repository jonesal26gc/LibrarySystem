import java.util.Date;

public class BorrowedBook {
    private int number = 0;
    private Book book;
    private Customer customer;
    private boolean active;
    private Date outDate;
    private Date inDate = null;

    public BorrowedBook(Book book, Customer customer) {
        this.book = book;
        this.customer = customer;
        this.active=true;
        this.outDate=new Date();
    }

    @Override
    public String toString() {
        return "BorrowedBook{" +
                "number=" + number +
                ", book=" + book +
                ", customer=" + customer +
                ", active=" + active +
                ", outDate=" + outDate +
                ", inDate=" + inDate +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getOutDate() {
        return outDate;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Book getBook() {

        return book;
    }
}
