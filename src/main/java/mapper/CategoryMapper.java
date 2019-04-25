package mapper;

import model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<CategoryModel> {
    @Override
    public CategoryModel map(ResultSet rs) throws SQLException {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(rs.getLong("id"));
        if (rs.getString("name") != null){
            categoryModel.setName(rs.getString("name"));
        }
        return categoryModel;
    }
}
