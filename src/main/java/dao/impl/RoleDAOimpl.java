package dao.impl;

import dao.IRoleDAO;
import mapper.RoleMapper;
import model.RoleModel;

import java.util.List;

public class RoleDAOimpl extends AbtractDAO<RoleModel> implements IRoleDAO {

    @Override
    public RoleModel findRoleById(long id) {
        String sql = "SELECT * FROM role WHERE id =?";
        List<RoleModel> roleModels = findByProperties(sql, new RoleMapper(), id);
        return roleModels.isEmpty() ? null : roleModels.get(0);
    }

    @Override
    public List<RoleModel> findAllRole() {
        String sql = "SELECT * FROM role ";
        List<RoleModel> roleModels = findByProperties(sql, new RoleMapper());
        return roleModels.isEmpty() ? null : roleModels;


    }

    @Override
    public void insertRole(RoleModel roleModel) {
        String sql = "INSERT INTO role(id, rolename) VALUES(?, ?) ";
        insert(sql, roleModel.getId(), roleModel.getRoleName());
    }

    @Override
    public void updateRole(long id, RoleModel roleModel) {
        String sql = "UPDATE role SET rolename = ? WHERE id = ? ";
        insert(sql, roleModel.getRoleName(), id);
    }
}
