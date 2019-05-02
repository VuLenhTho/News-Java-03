package controller.admin.api;

import model.NewsModel;
import model.UserModel;
import service.INewsService;
import service.IUserService;
import service.impl.NewsServiceImpl;
import service.impl.UserServiceimpl;
import utils.JsonToModelUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@WebServlet("/api/admin/user")
public class UserAPIController extends HttpServlet implements Serializable {
    private IUserService userService;

    public UserAPIController() {
        this.userService = new UserServiceimpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("/application/json");
        UserModel userModel = JsonToModelUtil.of(req.getReader()).toModel(UserModel.class);
        userService.insertUser(userModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("/application/json");
        UserModel userModel = JsonToModelUtil.of(req.getReader()).toModel(UserModel.class);
        userService.updateUser(userModel);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

}
