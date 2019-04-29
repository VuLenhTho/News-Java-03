package service;

import model.CategoryModel;

import java.util.List;

public interface ICategoryService {
    void insertCategory(CategoryModel categoryModel);

    void updateCategory(CategoryModel categoryModel);

    List<CategoryModel> findAllCategory();

    CategoryModel findCategoryByID(long id);

}
