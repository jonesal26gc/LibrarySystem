package application;

import application.model.BorrowedBook;

public interface BorrowedBookRepository {
    public BorrowedBook insertBorrowedBook(BorrowedBook borrowedBook);
    public void listBorrowedBooks();
    public BorrowedBook returnBorrowedBook(BorrowedBook borrowedBook);
    public int countBooks();
}
