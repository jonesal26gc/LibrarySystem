package application.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="BORROWEDBOOK")
public class BorrowedBook {
    // generate the unique from the "hibernate_sequences" table on the database.
    // The specific key for the sequence row is identified.
    @TableGenerator(
            name = "BorrowedBookIdGen",         // name of this generator.
            initialValue = 0,                   // starting value if the row is not already present.
            allocationSize = 1,                 // increment.
            table = "hibernate_sequences",      // table name for sequences.
            pkColumnName = "sequence_name",     // 'key' column name.
            valueColumnName = "next_val",       // 'next value' column name.
            pkColumnValue = "BORROWED_BOOK_ID") // key value for this row.

    // Unique key.
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "BorrowedBookIdGen")
    @Column(name = "BORROWED_BOOK_ID")
    private int borrowedBookId;

    @OneToOne
    @JoinColumn(name="BOOK_ID")                 // This is the foreign key to the BOOK table.
    private Book book;

    @OneToOne
    @JoinColumn(name="MEMBER_ID")               // This is the foreign key to the MEMBER table.
    private Member member;

    @Column(name = "OUT_DATE")
    @NotNull
    private Date outDate;

    @Column(name = "IN_DATE")
    private Date inDate;

    public BorrowedBook(int borrowedBookId, Book book, Member member, Date outDate) {
        this.borrowedBookId = borrowedBookId;
        this.book = book;
        this.member = member;
        this.outDate = outDate;
    }

    @Override
    public String toString() {
        return "BorrowedBook{" +
                "borrowedBookId=" + borrowedBookId +
                ", book=" + book +
                ", member=" + member +
                ", outDate=" + outDate +
                ", inDate=" + inDate +
                '}';
    }

    public int getBorrowedBookId() {
        return borrowedBookId;
    }

    public void setBorrowedBookId(int borrowedBookId) {
        this.borrowedBookId = borrowedBookId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }
}
