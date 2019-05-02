package service;

import model.RoleModel;

import java.util.List;

public interface IRoleService {
    RoleModel findRoleById(long id);

    List<RoleModel> findAllRole();
}
