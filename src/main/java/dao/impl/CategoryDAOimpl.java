package dao.impl;

import dao.ICategoryDAO;
import mapper.CategoryMapper;
import model.CategoryModel;

import java.util.List;

public class CategoryDAOimpl extends AbtractDAO<CategoryModel> implements ICategoryDAO {
    @Override
    public void insertCategory(CategoryModel categoryModel) {
        String sql = "INSERT INTO category(id, name) VALUES(?, ?) ";
        insert(sql, categoryModel.getId(), categoryModel.getName());
    }

    @Override
    public void updateCategory(CategoryModel categoryModel) {
        String sql = "UPDATE category SET name = ? WHERE id = ? ";
        insert(sql, categoryModel.getName(), categoryModel.getId());
    }

    @Override
    public List<CategoryModel> findAllCategory() {
        String sql = "SELECT * FROM category";
        return findByProperties(sql, new CategoryMapper());
    }

    @Override
    public CategoryModel findCategoryByID(long id) {
        String sql = "SELECT * FROM category";
        List<CategoryModel> list = findByProperties(sql, new CategoryMapper());
        return list.isEmpty() ? null : list.get(0);
    }
}
