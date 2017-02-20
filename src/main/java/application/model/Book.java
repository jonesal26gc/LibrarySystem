package application.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="BOOK")
public class Book {
    // generate the unique from the "hibernate_sequences" table on the database.
    // The specific key for the sequence row is identified.
    @TableGenerator(
            name = "BookIdGen",                 // name of this generator.
            initialValue = 0,                   // starting value if the row is not already present.
            allocationSize = 1,                 // increment.
            table = "hibernate_sequences",      // table name for sequences.
            pkColumnName = "sequence_name",     // 'key' column name.
            valueColumnName = "next_val",       // 'next value' column name.
            pkColumnValue = "BOOK_ID")          // key value for this row.

    // Unique key.
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "BookIdGen")
    @Column(name = "BOOK_ID")
    private int book_id;

    @Column(name = "TITLE")
    @NotNull
    private String title;

    @Column(name = "AUTHOR")
    @NotNull
    private String author;

    @Column(name = "PUBLICATION_VERSION")
    @NotNull
    private String publicationVersion;

    @Column(name = "PUBLICATION_DATE")
    @NotNull
    private Date publicationDate;

    @Column(name = "COST_PRICE")
    @NotNull
    private double costPrice;

    @Column(name = "BOOK_CATEGORY_CODE")
    @NotNull
    private String bookCategoryCode;

    @Column(name = "BOOK_SUBJECT_CODE")
    @NotNull
    private String bookSubjectCode;

    public Book() {
    }

    public Book(int book_id, String title, String author,
                String publicationVersion, Date publicationDate,
                double costPrice, String bookCategoryCode,
                String bookSubjectCode) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.publicationVersion = publicationVersion;
        this.publicationDate = publicationDate;
        this.costPrice = costPrice;
        this.bookCategoryCode = bookCategoryCode;
        this.bookSubjectCode = bookSubjectCode;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationVersion='" + publicationVersion + '\'' +
                ", publicationDate=" + publicationDate +
                ", costPrice=" + costPrice +
                ", bookCategoryCode='" + bookCategoryCode + '\'' +
                ", bookSubjectCode='" + bookSubjectCode + '\'' +
                '}';
    }

    public int getBook_id() {
        return book_id;
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

    public String getBookCategoryCode() {
        return bookCategoryCode;
    }

    public String getBookSubjectCode() {
        return bookSubjectCode;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationVersion(String publicationVersion) {
        this.publicationVersion = publicationVersion;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public void setBookCategoryCode(String bookCategoryCode) {
        this.bookCategoryCode = bookCategoryCode;
    }

    public void setBookSubjectCode(String bookSubjectCode) {
        this.bookSubjectCode = bookSubjectCode;
    }
}
