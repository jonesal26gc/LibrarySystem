package application;

import application.model.BorrowedBook;

import java.util.Date;
import java.util.HashMap;

public class BorrowedBookRegister implements BorrowedBookRepository {

    private HashMap<Integer, BorrowedBook> borrowedBooks = new HashMap<Integer, BorrowedBook>();
    private int lastNumber = 1;

    public BorrowedBook insertBorrowedBook(BorrowedBook borrowedBook) {
        borrowedBook.setBorrowedBookId(lastNumber++);
        borrowedBooks.put(borrowedBook.getBorrowedBookId(), borrowedBook);
        return borrowedBook;
    }

    public void listBorrowedBooks() {
        for (BorrowedBook borrowedBook : borrowedBooks.values()) {
            System.out.println(borrowedBook.toString());
        }
    }

    public BorrowedBook returnBorrowedBook(BorrowedBook borrowedBook) {
        borrowedBook.setInDate(new Date());
        borrowedBooks.put(borrowedBook.getBorrowedBookId(), borrowedBook);
        return borrowedBook;
    }

    public int countBooks() {
        int count = 0;
        for (BorrowedBook borrowedBook : borrowedBooks.values()) {
            count++;
        }
        return count;
    }
}
