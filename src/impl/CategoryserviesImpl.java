package impl;

import java.util.ArrayList;

import dao.CategoryDao;
import dao.DaoFactory;
import dto.CategoryDTO;
import entity.CategoryEntity;
import servies.CategoryServies;

public class CategoryserviesImpl implements CategoryServies{

    private final CategoryDao categoryDao;

    public CategoryserviesImpl() {
        this.categoryDao = (CategoryDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CATEGORY);
    }


    @Override
    public String save(CategoryDTO categoryDto) throws Exception {
        CategoryEntity entity = getCategoryEntity(categoryDto);
        return categoryDao.save(entity) ? "Success" : "Fail";
    }

    @Override
    public String update(CategoryDTO categoryDto) throws Exception {
        CategoryEntity entity = getCategoryEntity(categoryDto);
        return categoryDao.update(entity) ? "Success" : "Fail";
    }

    @Override
    public String delete(String categoryId) throws Exception {
        return categoryDao.delete(categoryId) ? "Success" : "Fail";
    }

    @Override
    public CategoryDTO get(String categoryId) throws Exception {
        CategoryEntity entity = categoryDao.get(categoryId);
        if (entity != null) {
            return getCategoryDto(entity);
        }
        return null;
    }

    @Override
    public ArrayList<CategoryDTO> getAll() throws Exception {
        ArrayList<CategoryEntity> categoryEntities = categoryDao.getAll();
        if (categoryEntities != null && !categoryEntities.isEmpty()) {
            ArrayList<CategoryDTO> categoryDtos = new ArrayList<>();
            for (CategoryEntity entity : categoryEntities) {
                categoryDtos.add(getCategoryDto(entity));
            }
            return categoryDtos ;
        }
        return null;
    }

    @Override
    public ArrayList<CategoryDTO> getAllUsers(String search) throws Exception {
        ArrayList<CategoryEntity> categoryEntities = categoryDao.getAllUsers(search);
        if (categoryEntities != null && !categoryEntities.isEmpty()) {
            ArrayList<CategoryDTO> categoryDtos = new ArrayList<>();
            for (CategoryEntity entity : categoryEntities) {
                categoryDtos.add(getCategoryDto(entity));
            }
            return categoryDtos ;
        }
        return null;
    }

    




    private CategoryEntity getCategoryEntity(CategoryDTO categoryDTO) {
        return new CategoryEntity(
            categoryDTO.getCategoryId(),
            categoryDTO.getBookCategory(),
            categoryDTO.getQtyOfBooks(),
            categoryDTO.getPairsOfBooks()
        );
    }

    private CategoryDTO getCategoryDto(CategoryEntity entity) {
        return new CategoryDTO(
            entity.getCategoryId(),
            entity.getBookCategory(),
            entity.getQtyOfBooks(),
            entity.getPairsOfBooks()
        );
    }

}