package impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import crud.CrudUtil;
import dao.BookDao;
import entity.BookEntity;

public class BookDaoImpl implements BookDao{

    @Override
    public boolean save(BookEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO books VALUES(?,?,?,?,?,?,?,?,?)", t.getBookID(), t.getBookName(), t.getAuthor(), t.getPublishDate(),t.getAbility(),t.getUserID(),t.getCatagoryID(),t.getReleasedDate(),t.getFine());

    }

    @Override
    public boolean update(BookEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE books SET Book_Name  = ?, Author = ?, Publish_Date = ? , Availability=? , User_ID=? , Category_ID = ? , Released_Date=?, Fine=? WHERE Book_ID  = ?", t.getBookName(), t.getAuthor(), t.getPublishDate(),t.getAbility(),t.getUserID(),t.getCatagoryID(),t.getReleasedDate(), t.getFine(), t.getBookID());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM books WHERE book_ID = ?", id);

    }

    @Override
    public BookEntity get(String id) throws Exception {
       ResultSet rst = CrudUtil.executeQuery("SELECT * FROM books WHERE book_ID = ?", id);
                if(rst.next()){
                    BookEntity entity = new BookEntity(rst.getString("book_ID"), 
                            rst.getString("Book_Name"),
                            rst.getString("Author"), 
                            rst.getString("Publish_Date"), 
                            rst.getString("Availability"),
                            rst.getString("User_ID"),
                            rst.getString("Category_ID"),
                            rst.getString("Released_Date"),
                            rst.getString("Fine"));
                    return entity;
                }
                return null;
    }

    @Override
    public ArrayList<BookEntity> getAll() throws Exception {
        ArrayList<BookEntity> bookEntities = new ArrayList<>();
                ResultSet rst = CrudUtil.executeQuery("SELECT * FROM books");
                while (rst.next()) {
                    BookEntity entity = new BookEntity(rst.getString("book_ID"), 
                    rst.getString("Book_Name"),
                    rst.getString("Author"), 
                    rst.getString("Publish_Date"), 
                    rst.getString("Availability"),
                    rst.getString("User_ID"),
                    rst.getString("Category_ID"),
                    rst.getString("Released_Date"),
                    rst.getString("Fine"));
                    bookEntities.add(entity);
                }
                return bookEntities;
    }

    @Override
    public ArrayList<BookEntity> getAllUsers(String t) throws Exception {
        ArrayList<BookEntity> bookEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM books WHERE CONCAT(book_ID, Book_Name, Author, Publish_Date,Availability,User_ID,Category_ID,Released_Date,Fine) REGEXP ?", t);

                while (rst.next()) {
                    BookEntity entity = new BookEntity(rst.getString("book_ID"), 
                    rst.getString("Book_Name"),
                    rst.getString("Author"), 
                    rst.getString("Publish_Date"), 
                    rst.getString("Availability"),
                    rst.getString("User_ID"),
                    rst.getString("Category_ID"),
                    rst.getString("Released_Date"),
                    rst.getString("Fine"));
                    bookEntities.add(entity);
                }
                return bookEntities;
    }
    
}
