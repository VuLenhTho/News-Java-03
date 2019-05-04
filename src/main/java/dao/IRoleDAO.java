package dao;

import model.RoleModel;

import java.util.List;

public interface IRoleDAO extends IGenericDAO<RoleModel> {
    RoleModel findRoleById(long id);

    List<RoleModel> findAllRole();

    void insertRole(RoleModel roleModel);

    void updateRole(long id, RoleModel roleModel);
}
