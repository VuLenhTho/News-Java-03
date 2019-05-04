package dao.impl;

import dao.ICategoryDAO;
import mapper.CategoryMapper;
import model.CategoryModel;

import java.util.List;

public class CategoryDAOimpl extends AbtractDAO<CategoryModel> implements ICategoryDAO {
    @Override
    public void insertCategory(CategoryModel categoryModel) {
        String sql = "INSERT INTO category(name) VALUES(?) ";
        insert(sql, categoryModel.getName());
    }

    @Override
    public void updateCategory(long id,CategoryModel categoryModel) {
        String sql = "UPDATE category SET name = ? WHERE id = ? ";
        insert(sql, categoryModel.getName(), id);
    }

    @Override
    public List<CategoryModel> findAllCategory() {
        String sql = "SELECT * FROM category";
        return findByProperties(sql, new CategoryMapper());
    }

    @Override
    public CategoryModel findCategoryByID(long id) {
        String sql = "SELECT * FROM category WHERE id =?";
        List<CategoryModel> list = findByProperties(sql, new CategoryMapper(),id);
        return list.isEmpty() ? null : list.get(0);
    }
}
