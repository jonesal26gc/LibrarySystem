package application;

import java.util.HashMap;

public class BookCatalogue {
    private HashMap<Integer, Book> books = new HashMap<Integer, Book>();

    public Book insertBook(Book book) {
        book.setNumber(findNextNumber());
        books.put(book.getNumber(), book);
        return book;
    }

    private int findNextNumber() {
        for (int number = 1; true; number++) {
            if (!books.containsKey(number)) {
                return number;
            }
        }
    }

    public int obtainNumberOfBooks() {
        return books.size();
    }

    public void listBooks() {
        for (Book book : books.values()) {
            System.out.println(book.toString());
        }
    }
}
