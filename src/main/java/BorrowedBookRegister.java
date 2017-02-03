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
            if (borrowedBook.isActive()) {
                System.out.println(borrowedBook.toString());
            }
        }
    }

    public BorrowedBook returnBook(int number) {
        BorrowedBook borrowedBook = borrowedBooks.get(number);
        borrowedBook.setInDate(new Date());
        borrowedBook.setActive(false);
        borrowedBooks.put(number, borrowedBook);
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
