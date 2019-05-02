package service.impl;

import dao.IUserDAO;
import dao.impl.UserDAOimpl;
import model.UserModel;
import model.request.UserRequest;
import service.IUserService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class UserServiceimpl implements IUserService {
    private IUserDAO userDAO;

    public UserServiceimpl() {
        this.userDAO = new UserDAOimpl();
    }

    @Override
    public UserModel findUserByUserNameAndPassword(UserRequest userRequest) {
        return userDAO.findUserByUserNameAndPassword(userRequest.getUserName(), userRequest.getPassword());
    }

    @Override
    public List<UserModel> findAllUser() {
        return userDAO.findAllUser();
    }

    @Override
    public void insertUser(UserModel userModel) {
        Date date = new Date();
        userModel.setCreatedDate(new Timestamp(date.getTime()));
        userDAO.insertUser(userModel);
    }



    @Override
    public void updateUser(UserModel userModel) {
        UserModel userModel1 = userDAO.findUserByID(userModel.getId());
        userModel.setCreatedDate(userModel1.getCreatedDate());
        userModel.setPassWord(userModel1.getPassWord());
        userDAO.updateUser(userModel,userModel.getId());
    }

    @Override
    public UserModel findUserByID(long id) {
        return userDAO.findUserByID(id);
    }
}
