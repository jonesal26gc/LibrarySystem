public class Library {
    private String name;
    private Address address;
    private Membership membership = new Membership();
    private BookCatalogue bookCatalogue = new BookCatalogue();
    private BorrowedBookRegister borrowedBookRegister = new BorrowedBookRegister();

    public Library(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public void enrollNewCustomer(Customer customer) {
        membership.addCustomer(customer);
    }

    public int obtainNumberOfMembers() {
        return membership.getNumberOfCustomers();
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public void listCustomers() {
        membership.listCustomers();
    }

    public void insertBookIntoCatalogue(Book book) {
        bookCatalogue.insertBook(book);
    }

    public void borrowBook(Book book, Customer customer) {
        borrowedBookRegister.insertBorrowedBook(new BorrowedBook(book, customer));
    }

    public int obtainNumberOfBooks() {
        return bookCatalogue.obtainNumberOfBooks();
    }

    public void listBooks() {
        bookCatalogue.listBooks();
    }

    public void listBorrowedBooks() {
        borrowedBookRegister.listBorrowedBooks();
    }
}
