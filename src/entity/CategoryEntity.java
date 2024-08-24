package entity;

public class CategoryEntity {
    
    String categoryId;
    String bookCategory;
    String QtyOfBooks;
    String PairsOfBooks;
    public CategoryEntity(String categoryId, String bookCategory, String qtyOfBooks, String pairsOfBooks) {
        this.categoryId = categoryId;
        this.bookCategory = bookCategory;
        QtyOfBooks = qtyOfBooks;
        PairsOfBooks = pairsOfBooks;
    }
    public String getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    public String getBookCategory() {
        return bookCategory;
    }
    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }
    public String getQtyOfBooks() {
        return QtyOfBooks;
    }
    public void setQtyOfBooks(String qtyOfBooks) {
        QtyOfBooks = qtyOfBooks;
    }
    public String getPairsOfBooks() {
        return PairsOfBooks;
    }
    public void setPairsOfBooks(String pairsOfBooks) {
        PairsOfBooks = pairsOfBooks;
    }
    @Override
    public String toString() {
        return "CategoryDTO [categoryId=" + categoryId + ", bookCategory=" + bookCategory + ", QtyOfBooks=" + QtyOfBooks
                + ", PairsOfBooks=" + PairsOfBooks + "]";
    }
    
}
