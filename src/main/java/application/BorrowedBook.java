package application;

import application.model.Member;

import java.util.Date;

public class BorrowedBook {
    private int number = 0;
    private int bookNumber;
    private int memberNumber;
    private boolean active;
    private Date outDate;
    private Date inDate = null;

    public BorrowedBook(Book book, Member member) {
        this.bookNumber = book.getNumber();
        this.memberNumber = member.getMember_id();
        this.active=true;
        this.outDate=new Date();
    }

    @Override
    public String toString() {
        return "application.BorrowedBook{" +
                "number=" + number +
                ", book=" + bookNumber +
                ", member=" + memberNumber +
                ", active=" + active +
                ", outDate=" + outDate +
                ", inDate=" + inDate +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getOutDate() {
        return outDate;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public int getMemberNumber() {
        return memberNumber;
    }
}
