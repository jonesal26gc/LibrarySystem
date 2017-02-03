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

    public void insertBookIntoCatalogue(Book book) {
        bookCatalogue.insertBook(book);
    }

    public int obtainBookCount() {
        return bookCatalogue.obtainNumberOfBooks();
    }

    public void listBooks() {
        bookCatalogue.listBooks();
    }

    public void registerMember(Member member) {
        membership.addMember(member);
    }

    public int obtainMemberCount() {
        return membership.getNumberOfMembers();
    }

    public void listMembers() {
        membership.listMembers();
    }

    public BorrowedBook borrowBook(Book book, Member member) {
        return borrowedBookRegister.insertBorrowedBook(new BorrowedBook(book, member));
    }

    public BorrowedBook returnBook(int number) {
        return borrowedBookRegister.returnBook(number);
    }

    public void listBorrowedBooks() {
        borrowedBookRegister.listBorrowedBooks();
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public int obtainBorrowedBookCount() {
        return borrowedBookRegister.countBooks();
    }
}
