public class BorrowedBook {
    private int number = 0;
    private Book book;
    private Customer customer;

    public BorrowedBook(Book book, Customer customer) {
        this.book = book;
        this.customer = customer;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "BorrowedBook{" +
                "number=" + number +
                ", book=" + book.getNumber() + ":" + book.getTitle() + " is out to " +
                ", customer=" + customer.getNumber() + ":" + customer.getSurname() +
                '}';
    }

    public int getNumber() {
        return number;
    }
}
