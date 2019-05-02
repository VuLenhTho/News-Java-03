package controller.admin;

import model.RoleModel;
import model.UserModel;
import service.ICategoryService;
import service.INewsService;
import service.IRoleService;
import service.IUserService;
import service.impl.RoleServiceImpl;
import service.impl.UserServiceimpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/user")
public class UserController extends HttpServlet {
    public static final String TYPE = "type";
    public static final String ACTION_EDIT = "edit";
    public static final String ACTION_CREATE = "create";
    public static final String EMPTY = "";

    private IUserService userService;
    private IRoleService roleService;

    public UserController() {
        this.roleService = new RoleServiceImpl();
        this.userService = new UserServiceimpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserModel> userModelList = userService.findAllUser();
        req.setAttribute("userModelList",userModelList);
        List<RoleModel> roleModelList = roleService.findAllRole();
        req.setAttribute("roleModelList",roleModelList);
        String type = req.getParameter(TYPE);
        String view = EMPTY;
        if (type != null){
            if (ACTION_EDIT.equals(type)) {
                String parameter = req.getParameter("id");
                if (!parameter.equals("")) {
                    long ID = Long.parseLong(parameter);
                    UserModel userModel = userService.findUserByID(ID);
                    if (userModel != null) {
                        req.setAttribute("model", userModel);
                        view = "/views/admin/user/edit_user.jsp";
                    } else {
                        req.setAttribute("message", "NewsModel isn't exist");
                    }
                }
            }
            if (ACTION_CREATE.equals(type)){
                view = "/views/admin/user/edit_user.jsp";
            }
        }else {
            view = "/views/admin/user/user_list.jsp";
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
