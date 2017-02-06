package application;

public interface BorrowedBookRepository {


    /**************
     *
     * @param borrowedBook
     * @return
     *
     * You require a function to insert an record of a book being issues to
     * a library member.
     *
     */
    public BorrowedBook insertBorrowedBook(BorrowedBook borrowedBook);

    public void listBorrowedBooks();
    public BorrowedBook returnBorrowedBook(int number);
    public int countBooks();
}
