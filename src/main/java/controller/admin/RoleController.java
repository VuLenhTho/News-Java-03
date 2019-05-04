package controller.admin;

import model.RoleModel;
import service.IRoleService;
import service.impl.RoleServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/role")
public class RoleController extends HttpServlet {

    public static final String TYPE = "type";
    public static final String ACTION_EDIT = "edit";
    public static final String ACTION_CREATE = "create";
    public static final String EMPTY = "";

    private IRoleService roleService;

    public RoleController() {
        this.roleService = new RoleServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RoleModel> roleModelList = roleService.findAllRole();
        req.setAttribute("roleModelList",roleModelList);
        String type = req.getParameter(TYPE);
        String view = EMPTY;
        if (type != null) {
            if (ACTION_EDIT.equals(type)) {
                String parameter = req.getParameter("id");
                if (!parameter.equals("")) {
                    long ID = Long.parseLong(parameter);
                    RoleModel roleModel = roleService.findRoleById(ID);
                    if (roleModel != null) {
                        req.setAttribute("roleModel", roleModel);
                        view = "/views/admin/role/edit_role.jsp";
                    } else {
                        req.setAttribute("message", "RoleModel isn't exist");
                    }

                }

            }
            if (ACTION_CREATE.equals(type)){
                view = "/views/admin/role/edit_role.jsp";
            }
        }else {
            view = "/views/admin/role/role_list.jsp";
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
        requestDispatcher.forward(req,resp);
    }
}
