package application.model;

import java.util.Date;

public class BorrowedBook {
    private int borrowedBookId;
    private int bookId;
    private int memberId;
    private boolean activeIndicator;
    private Date outDate;
    private Date inDate = null;

    public BorrowedBook(int borrowedBookId, int bookId,
                        int memberId, boolean activeIndicator,
                        Date outDate) {
        this.borrowedBookId = borrowedBookId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.activeIndicator = activeIndicator;
        this.outDate = outDate;
    }

    @Override
    public String toString() {
        return "BorrowedBook{" +
                "borrowedBookId=" + borrowedBookId +
                ", bookId=" + bookId +
                ", memberId=" + memberId +
                ", activeIndicator=" + activeIndicator +
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

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public boolean isActiveIndicator() {
        return activeIndicator;
    }

    public void setActiveIndicator(boolean activeIndicator) {
        this.activeIndicator = activeIndicator;
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
