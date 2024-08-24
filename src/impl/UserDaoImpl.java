package impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import crud.CrudUtil;
import dao.UserDao;
import entity.UserEntity;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean save(UserEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO users VALUES(?,?,?,?,?)", t.getUser_ID(), t.getUser_Name(), t.getAddress(), t.getContactNO(), t.getJoiDate());
    }

    @Override
    public boolean update(UserEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE users SET User_Name  = ?, Address = ?, Contact_Number = ?, Join_Date = ? WHERE User_ID  = ?", t.getUser_Name(), t.getAddress(), t.getContactNO(), t.getJoiDate(), t.getUser_ID());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM users WHERE User_ID = ?", id);

    }

    @Override
    public UserEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM users WHERE User_ID = ?", id);
                if(rst.next()){
                    UserEntity entity = new UserEntity(rst.getString("User_ID"), 
                            rst.getString("User_Name"), rst.getString("Address"), 
                            rst.getString("Contact_Number"), rst.getString("Join_Date"));
                    return entity;
                }
                return null;
    }

    @Override
    public ArrayList<UserEntity> getAll() throws Exception {
        ArrayList<UserEntity> userEntities = new ArrayList<>();
                ResultSet rst = CrudUtil.executeQuery("SELECT * FROM users");
                while (rst.next()) {
                    UserEntity entity = new UserEntity(rst.getString("User_ID"), 
                    rst.getString("User_Name"), rst.getString("Address"), 
                    rst.getString("Contact_Number"), rst.getString("Join_Date"));
                    userEntities.add(entity);
                }
                return userEntities;
            }

    @Override
    public ArrayList<UserEntity> getAllUsers(String t) throws Exception {
        ArrayList<UserEntity> userEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM users WHERE CONCAT(User_ID, User_Name, Address, Contact_Number, Join_Date) REGEXP ?", t);

                while (rst.next()) {
                    UserEntity entity = new UserEntity(rst.getString("User_ID"), 
                    rst.getString("User_Name"), rst.getString("Address"), 
                    rst.getString("Contact_Number"), rst.getString("Join_Date"));
                    userEntities.add(entity);
                }
                return userEntities;
    }


    
    
}
