package impl;

import java.util.ArrayList;

import dao.BookDao;
import dao.DaoFactory;
import dto.BookDTO;
import entity.BookEntity;
import servies.BookServies;

public class BookServiesImpl implements BookServies{

    private final BookDao bookDao;

    public BookServiesImpl() {
        this.bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);
    }

    @Override
    public String save(BookDTO bookDTO) throws Exception {
        BookEntity entity = getBookEntity(bookDTO);
        return bookDao.save(entity) ? "Success" : "Fail";
    }

    @Override
    public String update(BookDTO bookDTO) throws Exception {
        BookEntity entity = getBookEntity(bookDTO);
        return bookDao.update(entity) ? "Success" : "Fail";
    }

    @Override
    public String delete(String bookId) throws Exception {
        return bookDao.delete(bookId) ? "Success" : "Fail";
    }

    @Override
    public BookDTO get(String bookId) throws Exception {
        BookEntity entity = bookDao.get(bookId);
        if (entity != null) {
            return getBookDto(entity);
        }
        return null;
    }

    @Override
    public ArrayList<BookDTO> getAll() throws Exception {
        ArrayList<BookEntity> bookEntities = bookDao.getAll();
        if (bookEntities != null && !bookEntities.isEmpty()) {
            ArrayList<BookDTO> bookDTOs = new ArrayList<>();
            for (BookEntity entity : bookEntities) {
                bookDTOs.add(getBookDto(entity));
            }
            return bookDTOs ;
        }
        return null;
    }

    @Override
    public ArrayList<BookDTO> getAllUsers(String search) throws Exception {
        ArrayList<BookEntity> bookEntities = bookDao.getAllUsers(search);
        if (bookEntities != null && !bookEntities.isEmpty()) {
            ArrayList<BookDTO> bookDTOs = new ArrayList<>();
            for (BookEntity entity : bookEntities) {
                bookDTOs.add(getBookDto(entity));
            }
            return bookDTOs ;
        }
        return null;
    }

    private BookEntity getBookEntity(BookDTO bookDTO) {
        return new BookEntity(
            bookDTO.getBookID(),
            bookDTO.getBookName(),
            bookDTO.getAuthor(),
            bookDTO.getPublishDate(),
            bookDTO.getAbility(),
            bookDTO.getUserID(),
            bookDTO.getCatagoryID(),
            bookDTO.getReleasedDate(),
            bookDTO.getFine()

        );
    }

    private BookDTO getBookDto(BookEntity entity) {
        return new BookDTO(
            entity.getBookID(),
            entity.getBookName(),
            entity.getAuthor(),
            entity.getPublishDate(),
            entity.getAbility(),
            entity.getUserID(),
            entity.getCatagoryID(),
            entity.getReleasedDate(),
            entity.getFine()
        );
    }

    
    
}
