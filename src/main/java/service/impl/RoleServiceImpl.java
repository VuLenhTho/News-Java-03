package service.impl;

import dao.IRoleDAO;
import dao.impl.RoleDAOimpl;
import model.RoleModel;
import service.IRoleService;

import java.util.List;

public class RoleServiceImpl implements IRoleService {
    private IRoleDAO roleDAO;

    public RoleServiceImpl() {
        roleDAO = new RoleDAOimpl();
    }

    @Override
    public RoleModel findRoleById(long id) {
        return roleDAO.findRoleById(id);
    }

    @Override
    public List<RoleModel> findAllRole() {
        return roleDAO.findAllRole();
    }
}
