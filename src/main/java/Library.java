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

    public void enroll(Customer customer) {
        membership.addCustomer(customer);
    }

    public int findNumberOfMembers() {
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

    public void addBookToCatalogue(Book book) {
        bookCatalogue.addBook(book);
    }

    public void borrowBook(Book book, Customer customer) {
        borrowedBookRegister.addBorrowedBook(new BorrowedBook(book, customer));
    }

    public int findNumberOfBooks() {
        return bookCatalogue.getNumberOfBooks();
    }

    public void listBooks() {
        bookCatalogue.listBooks();
    }

    public void listBorrowedBooks() {
        borrowedBookRegister.listBorrowedBooks();
    }
}
