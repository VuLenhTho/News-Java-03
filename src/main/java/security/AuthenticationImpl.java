package security;

import model.RoleModel;
import model.UserModel;
import model.request.UserRequest;
import service.IRoleService;
import service.IUserService;
import service.impl.RoleServiceImpl;
import service.impl.UserServiceimpl;
import utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationImpl implements Authentication {
    private String userName;
    private String password;
    private IUserService userService;
    private IRoleService roleService;

    public AuthenticationImpl(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.userService = new UserServiceimpl();
        this.roleService = new RoleServiceImpl();
    }

    @Override
    public String urlRedirect(HttpServletRequest request) {
        UserModel userModel = userService.findUserByUserNameAndPassword(new UserRequest(userName, password));
        if (userModel == null) {
            return "/login?message=loginError";
        } else {
            SessionUtil.putValue(request, "USER", userModel);
            RoleModel roleModel = roleService.findRoleById(userModel.getRoleID());
            if (roleModel.getRoleName().equals("admin") || roleModel.getRoleName().equals("editor")) {
                return "/admin";
            } else if (roleModel.getRoleName().equals("user")) {
                return "/trangChu";
            }
        }
        return null;
    }
}

