package dao;

import model.UserModel;

public interface IUserDAO extends IGenericDAO<UserModel> {
    void insertUser(UserModel userModel);

    void updateUser(UserModel userModel, Long userID);

    UserModel findUserByUserNameAndPassword(String userName, String password);
}
