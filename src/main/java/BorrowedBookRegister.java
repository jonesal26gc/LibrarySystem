public interface BorrowedBookRegister {


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

    /*********************
     * You require a function to list all the books that have been lent out.
     *
     */
    public void listBorrowedBooks();


    public BorrowedBook returnBook(int number);
    public int countBooks();
}
