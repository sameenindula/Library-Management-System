package dao;

import impl.BookDaoImpl;
import impl.CategoryDaoImpl;
import impl.UserDaoImpl;

public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new DaoFactory();
                }
            }
        }
        return daoFactory;
    }

    public SuperDao getDao(DaoTypes type) {
        switch (type) {
            case USERS:
                return new UserDaoImpl(); // Ensure UserDaoImpl implements SuperDao
            case CATEGORY:
                return new CategoryDaoImpl();
            case BOOK:
                return new BookDaoImpl();
            default:
                return null;
        }
    }

    public enum DaoTypes {
        USERS,CATEGORY,BOOK
    }
}
