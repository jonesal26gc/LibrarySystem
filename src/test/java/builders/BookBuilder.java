package builders;

import application.model.Book;

import java.util.Date;

public final class BookBuilder {
    // generate the unique from the "hibernate_sequences" table on the database.
    // The specific key for the sequence row is identified.
    // key value for this row.

    // Unique key.
    private int book_id;
    private String title;
    private String author;
    private String publicationVersion;
    private Date publicationDate;
    private double costPrice;
    private String bookCategoryCode;
    private String bookSubjectCode;

    private BookBuilder() {
    }

    public static BookBuilder aBook() {
        return new BookBuilder();
    }

    public BookBuilder withBook_id(int book_id) {
        this.book_id = book_id;
        return this;
    }

    public BookBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder withPublicationVersion(String publicationVersion) {
        this.publicationVersion = publicationVersion;
        return this;
    }

    public BookBuilder withPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    public BookBuilder withCostPrice(double costPrice) {
        this.costPrice = costPrice;
        return this;
    }

    public BookBuilder withBookCategoryCode(String bookCategoryCode) {
        this.bookCategoryCode = bookCategoryCode;
        return this;
    }

    public BookBuilder withBookSubjectCode(String bookSubjectCode) {
        this.bookSubjectCode = bookSubjectCode;
        return this;
    }

    public Book build() {
        Book book = new Book();
        book.setBook_id(book_id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublicationVersion(publicationVersion);
        book.setPublicationDate(publicationDate);
        book.setCostPrice(costPrice);
        book.setBookCategoryCode(bookCategoryCode);
        book.setBookSubjectCode(bookSubjectCode);
        return book;
    }
}
