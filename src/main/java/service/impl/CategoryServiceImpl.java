package service.impl;

import dao.ICategoryDAO;
import dao.impl.CategoryDAOimpl;
import model.CategoryModel;
import service.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {

    private ICategoryDAO categoryDAO;

    public CategoryServiceImpl() {
        categoryDAO = new CategoryDAOimpl();
    }

    @Override
    public void insertCategory(CategoryModel categoryModel) {
        categoryDAO.insertCategory(categoryModel);
    }

    @Override
    public void updateCategory(CategoryModel categoryModel) {
        categoryDAO.updateCategory(categoryModel.getId(),categoryModel);
    }

    @Override
    public List<CategoryModel> findAllCategory() {
        return categoryDAO.findAllCategory();
    }

    @Override
    public CategoryModel findCategoryByID(long id) {
        return categoryDAO.findCategoryByID(id);
    }
}
