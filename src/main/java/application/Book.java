package application;

import java.util.Date;

public class Book {
    private int number = 0;
    private String title;
    private String author;
    private String publicationVersion;
    private Date publicationDate;
    private double costPrice;
    private BookCategory bookCategory;
    private BookSubject bookSubject;

    public Book(String title, String author, String publicationVersion, Date publicationDate, double costPrice, BookCategory bookCategory, BookSubject bookSubject) {
        this.title = title;
        this.author = author;
        this.publicationVersion = publicationVersion;
        this.publicationDate = publicationDate;
        this.costPrice = costPrice;
        this.bookCategory = bookCategory;
        this.bookSubject = bookSubject;
    }

    @Override
    public String toString() {
        return "application.Book{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationVersion='" + publicationVersion + '\'' +
                ", publicationDate=" + publicationDate +
                ", costPrice=" + costPrice +
                ", bookCategory=" + bookCategory +
                ", bookSubject=" + bookSubject +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationVersion() {
        return publicationVersion;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public BookSubject getBookSubject() {
        return bookSubject;
    }
}
