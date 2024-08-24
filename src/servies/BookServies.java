package servies;

import java.util.ArrayList;

import dto.BookDTO;

public interface BookServies extends SuperServies{
    String save(BookDTO bookDTO) throws Exception;
    String update(BookDTO bookDTO) throws Exception;
    String delete(String booString) throws Exception;
    BookDTO get(String bookId) throws Exception;
    ArrayList<BookDTO> getAll() throws Exception;
    ArrayList<BookDTO> getAllUsers(String search) throws Exception;
}
