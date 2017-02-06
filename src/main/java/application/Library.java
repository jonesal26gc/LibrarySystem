package application;

public class Library {
    private String name;
    private Address address;
    private Membership membership = new Membership();
    private BookCatalogue bookCatalogue = new BookCatalogue();
    private BorrowedBookRepository borrowedBookRepository;

    public Library(String name, Address address, BorrowedBookRepository borrowedBookRepository) {
        this.name = name;
        this.address = address;
        this.borrowedBookRepository = borrowedBookRepository;
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
        return borrowedBookRepository.insertBorrowedBook(new BorrowedBook(book, member));
    }

    public BorrowedBook returnBook(BorrowedBook borrowedBook) {
        return borrowedBook;
    }

    public void listBorrowedBooks() {
        borrowedBookRepository.listBorrowedBooks();
    }

    public int obtainBorrowedBookCount() {
        return borrowedBookRepository.countBooks();
    }

    @Override
    public String toString() {
        return "application.Library{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
