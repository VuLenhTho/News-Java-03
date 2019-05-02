package service;

import model.UserModel;
import model.request.UserRequest;

import java.util.List;

public interface IUserService {
    UserModel findUserByUserNameAndPassword(UserRequest userRequest);

    List<UserModel> findAllUser();

    void insertUser(UserModel userModel);

    void updateUser(UserModel userModel);

    UserModel findUserByID(long id);
}
