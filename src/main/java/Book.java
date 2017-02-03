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

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
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

    public String getTitle() {
        return title;
    }
}
