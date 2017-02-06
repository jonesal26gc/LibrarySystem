package application;

import java.util.Date;

public class BorrowedBook {
    private int number = 0;
    private Book book;
    private Member member;
    private boolean active;
    private Date outDate;
    private Date inDate = null;

    public BorrowedBook(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.active=true;
        this.outDate=new Date();
    }

    @Override
    public String toString() {
        return "application.BorrowedBook{" +
                "number=" + number +
                ", book=" + book +
                ", member=" + member +
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

    public Member getMember() {
        return member;
    }

    public Book getBook() {

        return book;
    }
}
