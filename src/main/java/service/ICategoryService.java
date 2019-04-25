package service;

import model.CategoryModel;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ICategoryService {
    void insertCatergory(CategoryModel categoryModel);

    void updateCategory(CategoryModel categoryModel);

    List<CategoryModel> findAllCategory();

    CategoryModel findCategoryByID(long id);

}
