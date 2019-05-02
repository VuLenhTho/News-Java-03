package dao.impl;

import dao.IUserDAO;
import mapper.UserMapper;
import model.UserModel;

import java.util.List;

public class UserDAOimpl extends AbtractDAO<UserModel> implements IUserDAO {
    @Override
    public void insertUser(UserModel userModel) {
        String sql = "INSERT INTO user(username, password, firstname, " +
                "lastname, createddate, email, sex, roleid) value (?,?,?,?,?,?,?,?)";
        insert(sql, userModel.getUserName(),
                userModel.getPassWord(), userModel.getFirstName(),
                userModel.getLastName(), userModel.getCreatedDate(),
                userModel.getEmail(), userModel.getSex(),
                userModel.getRoleID());
    }

    @Override
    public void updateUser(UserModel userModel, Long userID) {
        String sql = "UPDATE user SET username =?,password=?,firstname=?," +
                "lastname=?,createddate=?,email=?,sex=?,roleid=? WHERE id=?";
        insert(sql, userModel.getUserName(), userModel.getPassWord(),
                userModel.getFirstName(), userModel.getLastName(),
                userModel.getCreatedDate(), userModel.getEmail(),
                userModel.getSex(), userModel.getRoleID(), userID);
    }

    @Override
    public UserModel findUserByUserNameAndPassword(String userName, String password) {
        String sql = "SELECT * FROM user WHERE username=? and password =?";
        List<UserModel> userModels = findByProperties(sql, new UserMapper(), userName, password);
        return userModels.isEmpty() ? null : userModels.get(0);
    }

    @Override
    public List<UserModel> findAllUser() {
        String sql = "SELECT * FROM user";
        List<UserModel> userModels = findByProperties(sql, new UserMapper());
        return userModels.isEmpty() ? null : userModels;
    }

    @Override
    public UserModel findUserByID(long id) {
        String sql = "SELECT * FROM user WHERE id =?";
        List<UserModel> userModels = findByProperties(sql, new UserMapper(), id);
        return userModels.isEmpty() ? null : userModels.get(0);
    }
}
