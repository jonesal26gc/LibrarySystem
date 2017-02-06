package application;

import java.util.Date;
import java.util.HashMap;

public class BorrowedBookRegister implements BorrowedBookRepository {

    private HashMap<Integer, BorrowedBook> borrowedBooks = new HashMap<Integer, BorrowedBook>();
    private int lastNumber = 1;

    public BorrowedBook insertBorrowedBook(BorrowedBook borrowedBook) {
        borrowedBook.setNumber(lastNumber++);
        borrowedBooks.put(borrowedBook.getNumber(), borrowedBook);
        return borrowedBook;
    }

    public void listBorrowedBooks() {
        for (BorrowedBook borrowedBook : borrowedBooks.values()) {
            if (borrowedBook.isActive()) {
                System.out.println(borrowedBook.toString());
            }
        }
    }

    public BorrowedBook returnBorrowedBook(BorrowedBook borrowedBook) {
        borrowedBook.setActive(false);
        borrowedBook.setInDate(new Date());
        borrowedBooks.put(borrowedBook.getNumber(), borrowedBook);
        return borrowedBook;
    }

    public int countBooks() {
        int count = 0;
        for (BorrowedBook borrowedBook : borrowedBooks.values()) {
            if (borrowedBook.isActive()) {
                count++;
            }
        }
        return count;
    }
}
