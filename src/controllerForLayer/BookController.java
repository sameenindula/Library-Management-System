package controllerForLayer;

import java.util.ArrayList;

import dto.BookDTO;
import servies.BookServies;
import servies.ServiesFactory;

public class BookController {
    private static BookServies BookServies = (BookServies) ServiesFactory.getInstance().getService(ServiesFactory.ServiceType.BOOK);

    public static String save(BookDTO bookDTO) throws Exception {
        return BookServies.save(bookDTO);
    }

    public static String update(BookDTO bookDTO) throws Exception {
        return BookServies.update(bookDTO);
    }

    public static String delete(String categoryId) throws Exception {
        return BookServies.delete(categoryId);
    }

    public static ArrayList<BookDTO> getAllCategory() throws Exception {
        return BookServies.getAll();
    }
    public static ArrayList<BookDTO> getAllCategory(String search) throws Exception {
        return BookServies.getAllUsers(search);
    }
}
