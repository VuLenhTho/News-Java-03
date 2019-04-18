package controller.web;

import model.request.UserRequest;
import security.Authentication;
import service.IRoleService;
import service.IUserService;
import service.impl.RoleServiceImpl;
import service.impl.UserServiceimpl;
import utils.MapClientToSeverUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private IUserService userService;
    private IRoleService roleService;

    public LoginController() {
        this.userService = new UserServiceimpl();
        this.roleService = new RoleServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String messgae = req.getParameter("message");
        if (messgae != null ) {
            if (messgae.equals("loginError")){
                req.setAttribute("message", "Tài khoản hoặc mật khẩu bị sai");
            }else if (messgae.equals("permissionDenied")){
                req.setAttribute("message", "Bạn không đủ quyền truy cập vào trang này");
            }else if (messgae.equals("dontLogin")){
                req.setAttribute("message", "Bạn chưa đăng nhập");
            }
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/web/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRequest userRequest = MapClientToSeverUtil.toModel(UserRequest.class, req);
        String url = Authentication
                .newModel(userRequest.getUserName(), userRequest
                        .getPassword()).urlRedirect(req);
        resp.sendRedirect(url);
    }
}

