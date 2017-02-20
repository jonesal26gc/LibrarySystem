package application.enumerators;

public enum BookSubject {
    UNKNOWN(1),
    TRANSPORT(2),
    HISTORY(3),
    SCIENCE(4),
    NEWS(5),
    SPORT(6);

    private int bookSubjectId;

    BookSubject(int bookSubjectId) {
        this.bookSubjectId = bookSubjectId;
    }

    public int getBookSubjectId() {
        return bookSubjectId;
    }

    public BookSubject lookup(String bookSubjectId){
        for (BookSubject element : BookSubject.values()){
            if (this.bookSubjectId == element.bookSubjectId) return element;
        }
        return BookSubject.UNKNOWN;
    }
}
