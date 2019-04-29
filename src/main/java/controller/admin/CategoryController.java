package controller.admin;

import model.CategoryModel;
import service.ICategoryService;
import service.impl.CategoryServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/category")
public class CategoryController extends HttpServlet {

    public static final String TYPE = "type";
    public static final String ACTION_EDIT = "edit";
    public static final String ACTION_CREATE = "create";
    public static final String EMPTY = "";

    private ICategoryService categoryService;

    public CategoryController() {
        this.categoryService = new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CategoryModel> categoryModelList = categoryService.findAllCategory();
        req.setAttribute("categoryList", categoryModelList);
        String type = req.getParameter(TYPE);
        String view = EMPTY;

        if (type != null) {
            if (ACTION_EDIT.equals(type)) {
                String parameter = req.getParameter("id");
                if (!parameter.equals("")) { // khong the null
                    long ID = Long.parseLong(parameter);
                    CategoryModel categoryModel = categoryService.findCategoryByID(ID);
                    if (categoryModel != null) {
                        req.setAttribute("categoryModel", categoryModel);
                        view = "/views/admin/category/edit_category.jsp";
                    } else {
                        req.setAttribute("message", "CategoryModel isn't exist");
                    }

                }

            }
            if (ACTION_CREATE.equals(type)){
                view = "/views/admin/category/edit_category.jsp";
            }
        }else {
            view = "/views/admin/category/category_list.jsp";
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}