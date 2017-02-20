package application.enumerators;

public enum BookCategory {
    UNKNOWN(1),
    FICTION(2),
    NON_FICTION(3);

    private int bookCategoryId;

    BookCategory(int bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public int getBookCategoryId() {
        return bookCategoryId;
    }

    public BookCategory lookup(int bookCategoryId){
        for (BookCategory element : BookCategory.values()){
            if (bookCategoryId == element.bookCategoryId) return element;
        }
        return BookCategory.UNKNOWN;
    }
}
