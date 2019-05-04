package controller.admin.api;

import model.RoleModel;
import service.IRoleService;
import service.impl.RoleServiceImpl;
import utils.JsonToModelUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@WebServlet("/api/admin/role")
public class RoleAPIController extends HttpServlet implements Serializable {

    private IRoleService roleService;

    public RoleAPIController() {
        roleService=  new RoleServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("/application/json");
        RoleModel roleModel = JsonToModelUtil.of(req.getReader()).toModel(RoleModel.class);
        roleService.insertRole(roleModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("/application/json");
        RoleModel roleModel = JsonToModelUtil.of(req.getReader()).toModel(RoleModel.class);
        roleService.updateRole(roleModel);
    }
}
