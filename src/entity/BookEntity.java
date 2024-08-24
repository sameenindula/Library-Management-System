package entity;

public class BookEntity {
    String BookID;
    String BookName;
    String Author;
    String PublishDate;
    String Ability;
    String UserID;
    String CatagoryID;
    String ReleasedDate;
    String Fine;
    public BookEntity(String bookID, String bookName, String author, String publishDate, String ability, String userID,
            String catagoryID, String releasedDate, String fine) {
        BookID = bookID;
        BookName = bookName;
        Author = author;
        PublishDate = publishDate;
        Ability = ability;
        UserID = userID;
        CatagoryID = catagoryID;
        ReleasedDate = releasedDate;
        Fine = fine;
    }
    public String getBookID() {
        return BookID;
    }
    public void setBookID(String bookID) {
        BookID = bookID;
    }
    public String getBookName() {
        return BookName;
    }
    public void setBookName(String bookName) {
        BookName = bookName;
    }
    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author) {
        Author = author;
    }
    public String getPublishDate() {
        return PublishDate;
    }
    public void setPublishDate(String publishDate) {
        PublishDate = publishDate;
    }
    public String getAbility() {
        return Ability;
    }
    public void setAbility(String ability) {
        Ability = ability;
    }
    public String getUserID() {
        return UserID;
    }
    public void setUserID(String userID) {
        UserID = userID;
    }
    public String getCatagoryID() {
        return CatagoryID;
    }
    public void setCatagoryID(String catagoryID) {
        CatagoryID = catagoryID;
    }
    public String getReleasedDate() {
        return ReleasedDate;
    }
    public void setReleasedDate(String releasedDate) {
        ReleasedDate = releasedDate;
    }
    public String getFine() {
        return Fine;
    }
    public void setFine(String fine) {
        Fine = fine;
    }
    @Override
    public String toString() {
        return "BookEntity [BookID=" + BookID + ", BookName=" + BookName + ", Author=" + Author + ", PublishDate="
                + PublishDate + ", Ability=" + Ability + ", UserID=" + UserID + ", CatagoryID=" + CatagoryID
                + ", ReleasedDate=" + ReleasedDate + ", Fine=" + Fine + "]";
    }
    
    
}