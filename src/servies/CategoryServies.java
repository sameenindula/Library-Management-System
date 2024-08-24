package servies;

import java.util.ArrayList;

import dto.CategoryDTO;

public interface CategoryServies extends SuperServies{
    String save(CategoryDTO categoryDto) throws Exception;
    String update(CategoryDTO categoryDto) throws Exception;
    String delete(String categoryId) throws Exception;
    CategoryDTO get(String categoryId) throws Exception;
    ArrayList<CategoryDTO> getAll() throws Exception;
    ArrayList<CategoryDTO> getAllUsers(String search) throws Exception;
    
}
