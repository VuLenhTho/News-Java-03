package dao;

import model.UserModel;

import java.util.List;

public interface IUserDAO extends IGenericDAO<UserModel> {
    void insertUser(UserModel userModel);

    void updateUser(UserModel userModel, Long userID);

    UserModel findUserByUserNameAndPassword(String userName, String password);

    List<UserModel> findAllUser();

    UserModel findUserByID(long id);
}
