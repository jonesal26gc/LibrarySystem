import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class BorrowedBookRegister {
    private HashMap<Integer, BorrowedBook> borrowedBooks = new HashMap<Integer, BorrowedBook>();

    public BorrowedBook insertBorrowedBook(BorrowedBook borrowedBook) {
        borrowedBook.setNumber(findNextNumber());
        borrowedBooks.put(borrowedBook.getNumber(), borrowedBook);
        return borrowedBook;
    }

    private int findNextNumber() {
        for (int number = 1; true; number++) {
            if (!borrowedBooks.containsKey(number)) {
                return number;
            }
        }
    }

    public void listBorrowedBooks() {
        for (BorrowedBook borrowedBook : borrowedBooks.values()) {
            System.out.println(borrowedBook.toString());
        }
    }
}
