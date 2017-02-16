package application;

public enum BookSubject {
    UNKNOWN("UKN"),
    TRANSPORT("TRN"),
    HISTORY("HST"),
    SCIENCE("SCI"),
    NEWS("NEW"),
    SPORT("SPT");

    private String bookSubjectCode;

    BookSubject(String bookSubjectCode) {
        this.bookSubjectCode = bookSubjectCode;
    }

    public static BookSubject lookup(String bookSubjectCode){
        for (BookSubject element : BookSubject.values()){
            if (bookSubjectCode.equals(element.bookSubjectCode)) return element;
        }
        return BookSubject.UNKNOWN;
    }
}
