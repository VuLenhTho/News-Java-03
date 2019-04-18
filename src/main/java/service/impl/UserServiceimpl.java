package service.impl;

import dao.IUserDAO;
import dao.impl.UserDAOimpl;
import model.UserModel;
import model.request.UserRequest;
import service.IUserService;

public class UserServiceimpl implements IUserService {
    private IUserDAO userDAO;

    public UserServiceimpl() {
        this.userDAO = new UserDAOimpl();
    }

    @Override
    public UserModel findUserByUserNameAndPassword(UserRequest userRequest) {
        return userDAO.findUserByUserNameAndPassword(userRequest.getUserName(), userRequest.getPassword());
    }
}
