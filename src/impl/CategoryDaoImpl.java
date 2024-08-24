package impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import crud.CrudUtil;
import dao.CategoryDao;
import entity.CategoryEntity;


public class CategoryDaoImpl implements CategoryDao {

    @Override
    public boolean save(CategoryEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO categories VALUES(?,?,?,?)", t.getCategoryId(), t.getBookCategory(), t.getQtyOfBooks(), t.getPairsOfBooks());

    }

    @Override
    public boolean update(CategoryEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE categories SET Books_Category  = ?, Qty_Of_Books = ?, Pairs_of_Books = ? WHERE Category_ID  = ?", t.getBookCategory(), t.getQtyOfBooks(), t.getPairsOfBooks(), t.getCategoryId());

    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM categories WHERE Category_ID = ?", id);

    }

    @Override
    public CategoryEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM categories WHERE Category_ID = ?", id);
                if(rst.next()){
                    CategoryEntity entity = new CategoryEntity(rst.getString("Category_ID"), 
                            rst.getString("Books_Category"), rst.getString("Qty_Of_Books"), 
                            rst.getString("Pairs_of_Books"));
                    return entity;
                }
                return null;
    }
    

    @Override
    public ArrayList<CategoryEntity> getAll() throws Exception {
        ArrayList<CategoryEntity> categoryEntities = new ArrayList<>();
                ResultSet rst = CrudUtil.executeQuery("SELECT * FROM categories");
                while (rst.next()) {
                    CategoryEntity entity = new CategoryEntity(rst.getString("Category_ID"), 
                    rst.getString("Books_Category"), rst.getString("Qty_Of_Books"), 
                    rst.getString("Pairs_of_Books"));
                    categoryEntities.add(entity);
                }
                return categoryEntities;
    }

    @Override
    public ArrayList<CategoryEntity> getAllUsers(String t) throws Exception {
        ArrayList<CategoryEntity> categoryEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM categories WHERE CONCAT(Category_ID, Books_Category, Qty_Of_Books, Pairs_of_Books) REGEXP ?", t);

                while (rst.next()) {
                    CategoryEntity entity = new CategoryEntity(rst.getString("Category_ID"), 
                    rst.getString("Books_Category"),
                    rst.getString("Qty_Of_Books"), 
                    rst.getString("Pairs_of_Books"));
                    categoryEntities.add(entity);
                }
                return categoryEntities;
    }
    
}
