package application;

public enum BookSubject {
    TRANSPORT,
    HISTORY,
    SCIENCE,
    NEWS,
    SPORT;

    public static int getCode(BookSubject bookSubject){
        for (BookSubject element : BookSubject.values()){
            if (bookSubject == element) return element.ordinal();
        }
        return 0;
    }
}
