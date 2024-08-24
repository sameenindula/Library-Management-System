package servies;

import java.util.ArrayList;

import dto.UserDTO;

public interface UserServies extends SuperServies{
    String save(UserDTO userDto) throws Exception;
    String update(UserDTO userDTO) throws Exception;
    String delete(String user_ID) throws Exception;
    UserDTO get(String userId) throws Exception;
    ArrayList<UserDTO> getAll() throws Exception;
    ArrayList<UserDTO> getAllUsers(String search) throws Exception;
    
    }


