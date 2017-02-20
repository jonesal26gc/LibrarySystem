package application.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;
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

    @Column(name = "BOOK_TITLE")
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

    @Column(name = "BOOK_CATEGORY_ID")
    @NotNull
    private int bookCategoryId;

    @Column(name = "BOOK_SUBJECT_ID")
    @NotNull
    private int bookSubjectId;

    @Column(name="CREATED_TIMESTAMP")
    @NotNull
    private Timestamp createdTimestamp;

    @Column(name="MODIFIED_TIMESTAMP")
    private Timestamp modifiedTimestamp;

    public Book() {
    }

    public Book(int book_id, String title, String author,
                String publicationVersion, Date publicationDate,
                double costPrice, int bookCategoryId,
                int bookSubjectId) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.publicationVersion = publicationVersion;
        this.publicationDate = publicationDate;
        this.costPrice = costPrice;
        this.bookCategoryId = bookCategoryId;
        this.bookSubjectId = bookSubjectId;
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
                ", bookCategoryId='" + bookCategoryId + '\'' +
                ", bookSubjectId='" + bookSubjectId + '\'' +
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

    public int getBookCategoryId() {
        return bookCategoryId;
    }

    public int getBookSubjectId() {
        return bookSubjectId;
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

    public void setBookCategoryId(int bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public void setBookSubjectId(int bookSubjectId) {
        this.bookSubjectId = bookSubjectId;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public void setModifiedTimestamp(Timestamp modifiedTimestamp) {
        this.modifiedTimestamp = modifiedTimestamp;
    }
}
