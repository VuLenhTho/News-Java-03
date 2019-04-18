package mapper;

import model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    @Override
    public UserModel map(ResultSet rs) throws SQLException {
        UserModel userModel = new UserModel();
        userModel.setId(rs.getLong("userid"));
        if (rs.getString("username") != null) {
            userModel.setUserName(rs.getString("username"));
        }
        if (rs.getString("password") != null) {
            userModel.setPassWord(rs.getString("password"));
        }
        if (rs.getString("firstname") != null) {
            userModel.setFirstName(rs.getString("firstname"));
        }
        if (rs.getString("lastname") != null) {
            userModel.setLastName(rs.getString("lastname"));
        }
        userModel.setCreatedDate(rs.getTimestamp("createddate"));
        if (rs.getString("email") != null) {
            userModel.setEmail(rs.getString("email"));
        }
        userModel.setSex(rs.getInt("sex"));
        userModel.setRoleID(rs.getLong("roleid"));
        return userModel;
    }
}
