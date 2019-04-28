package service;

import model.CategoryModel;

import java.util.List;

public interface ICategoryService {
    void insertCatergory(CategoryModel categoryModel);

    void updateCategory(CategoryModel categoryModel);

    List<CategoryModel> findAllCategory();

    CategoryModel findCategoryByID(long id);

}
