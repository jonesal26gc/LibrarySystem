package application;

public enum BookCategory {
    UNKNOWN("UKN"),
    FICTION("F"),
    NON_FICTION("NF");

    private String bookCategoryCode;

    BookCategory(String bookCategoryCode) {
        this.bookCategoryCode = bookCategoryCode;
    }

    public BookCategory lookup(String bookCategoryCode){
        for (BookCategory element : BookCategory.values()){
            if (bookCategoryCode.equals(element.bookCategoryCode)) return element;
        }
        return BookCategory.UNKNOWN;
    }
}
