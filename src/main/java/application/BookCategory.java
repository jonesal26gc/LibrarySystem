package application;

public enum BookCategory {
    FICTION,
    NON_FICTION;

    public static int getCode(BookCategory bookCategory){
        for (BookCategory element : BookCategory.values()){
            if (bookCategory == element) return element.ordinal();
        }
        return 0;
    }
}
