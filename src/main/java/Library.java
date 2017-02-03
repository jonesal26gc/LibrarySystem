public class Library {
    private String name;
    private Address address;
    private Membership membership = new Membership();
    private BookCatalogue bookCatalogue = new BookCatalogue();

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

    public void addBookToCatalogue(Book book){
        bookCatalogue.addBook(book);
    }

    public void borrowBook(Customer customer, Book busBook) {

    }

    public int findNumberOfBooks() {
        return bookCatalogue.getNumberOfBooks();
    }

    public void listBooks() {
    }
}
