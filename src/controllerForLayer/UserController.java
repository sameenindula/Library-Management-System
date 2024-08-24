package controllerForLayer;

import java.util.ArrayList;

import dto.UserDTO;
import servies.ServiesFactory;
import servies.UserServies;

public class UserController {

    private static UserServies userServices = (UserServies) ServiesFactory.getInstance().getService(ServiesFactory.ServiceType.USERS);

    public static String save(UserDTO userDTO) throws Exception {
        return userServices.save(userDTO);
    }

    public static String update(UserDTO userDTO) throws Exception {
        return userServices.update(userDTO);
    }

    public static String delete(String userID) throws Exception {
        return userServices.delete(userID);
    }

    public static ArrayList<UserDTO> getAllUsers() throws Exception {
        return userServices.getAll();
    }
    public static ArrayList<UserDTO> getAllUsers(String search) throws Exception {
        return userServices.getAllUsers(search);
    }

    
}
