package controllerForLayer;

import java.util.ArrayList;

import dto.CategoryDTO;
import servies.CategoryServies;
import servies.ServiesFactory;


public class CategoryController {
    private static CategoryServies CategoryServies = (CategoryServies) ServiesFactory.getInstance().getService(ServiesFactory.ServiceType.CATEGORY);

    public static String save(CategoryDTO categoryDTO) throws Exception {
        return CategoryServies.save(categoryDTO);
    }

    public static String update(CategoryDTO categoryDTO) throws Exception {
        return CategoryServies.update(categoryDTO);
    }

    public static String delete(String categoryId) throws Exception {
        return CategoryServies.delete(categoryId);
    }

    public static ArrayList<CategoryDTO> getAllCategory() throws Exception {
        return CategoryServies.getAll();
    }
    public static ArrayList<CategoryDTO> getAllCategory(String search) throws Exception {
        return CategoryServies.getAllUsers(search);
    }
}
