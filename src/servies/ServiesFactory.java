package servies;

import impl.BookServiesImpl;
import impl.CategoryserviesImpl;
import impl.UserServiesImpl;

public class ServiesFactory {

    private static ServiesFactory serviesFactory;

    private ServiesFactory() {
    }

    public static ServiesFactory getInstance() {
        if (serviesFactory == null) {
            synchronized (ServiesFactory.class) {
                if (serviesFactory == null) {
                    serviesFactory = new ServiesFactory();
                }
            }
        }
        return serviesFactory;
    }

    public SuperServies getService(ServiceType type) {
        switch (type) {
            case USERS:
                return new UserServiesImpl(); // Ensure UserServicesImpl implements SuperService
            case CATEGORY:
                return new CategoryserviesImpl();
            case BOOK:
                return new BookServiesImpl();
                default:
                return null;
        }
    }

    public enum ServiceType {
        USERS,CATEGORY,BOOK
    }
}
