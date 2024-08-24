package impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.UserDao;
import dto.UserDTO;
import entity.UserEntity;
import servies.UserServies;

public class UserServiesImpl implements UserServies {

    private final UserDao userDao;

    public UserServiesImpl() {
        this.userDao = (UserDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.USERS);
    }

    @Override
    public String save(UserDTO userDto) throws Exception {
        UserEntity entity = getUserEntity(userDto);
        return userDao.save(entity) ? "Success" : "Fail";
    }

    @Override
    public String update(UserDTO userDto) throws Exception {
        UserEntity entity = getUserEntity(userDto);
        return userDao.update(entity) ? "Success" : "Fail";
    }

    @Override
    public String delete(String userID) throws Exception {
        return userDao.delete(userID) ? "Success" : "Fail";
    }

    @Override
    public UserDTO get(String userID) throws Exception {
        UserEntity entity = userDao.get(userID);
        if (entity != null) {
            return getUserDto(entity);
        }
        return null;
    }

    @Override
    public ArrayList<UserDTO> getAll() throws Exception {
        ArrayList<UserEntity> userEntities = userDao.getAll();
        if (userEntities != null && !userEntities.isEmpty()) {
            ArrayList<UserDTO> userDtos = new ArrayList<>();
            for (UserEntity entity : userEntities) {
                userDtos.add(getUserDto(entity));
            }
            return userDtos;
        }
        return null;
    }

    @Override
    public ArrayList<UserDTO> getAllUsers(String search) throws Exception {
        ArrayList<UserEntity> userEntities = userDao.getAllUsers(search);
        if (userEntities != null && !userEntities.isEmpty()) {
            ArrayList<UserDTO> userDtos = new ArrayList<>();
            for (UserEntity entity : userEntities) {
                userDtos.add(getUserDto(entity));
            }
            return userDtos;
        }
        return null;
    }




    private UserEntity getUserEntity(UserDTO userDTO) {
        return new UserEntity(
            userDTO.getUser_ID(),
            userDTO.getUser_Name(),
            userDTO.getAddress(),
            userDTO.getContactNO(),
            userDTO.getJoiDate()
        );
    }

    private UserDTO getUserDto(UserEntity entity) {
        return new UserDTO(
            entity.getUser_ID(),
            entity.getUser_Name(),
            entity.getAddress(),
            entity.getContactNO(),
            entity.getJoiDate()
        );
    }

    
}
