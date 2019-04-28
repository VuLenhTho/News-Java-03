package controller.admin;

import model.CategoryModel;
import model.NewsModel;
import service.ICategoryService;
import service.INewsService;
import service.impl.CategoryServiceImpl;
import service.impl.NewsServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/news")
public class NewsController extends HttpServlet {

    public static final String TYPE = "type";
    public static final String ACTION_EDIT = "edit";
    public static final String ACTION_CREATE = "create";
    public static final String EMPTY = "";
    private INewsService newsService;
    private ICategoryService categoryService;

    public NewsController() {
        this.newsService = new NewsServiceImpl();
        this.categoryService = new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NewsModel> results = newsService.findAll();
        req.setAttribute("models", results);
        String type = req.getParameter(TYPE);
        String view = EMPTY;
        if (isNotNull(type)) {
            if (ACTION_EDIT.equals(type)) {
                String parameter = req.getParameter("id");
                if (!isEmpty(parameter) && isNotNull(parameter)) {
                    long ID = Long.parseLong(parameter);
                    NewsModel newsModel = newsService.findNewsByID(ID);
                    if (isNotNull(newsModel)) {
                        req.setAttribute("model", newsModel);
                        view = "/views/admin/news/edit.jsp";
                    } else {
                        req.setAttribute("message", "NewsModel isn't exist");
                    }
                }
            }
            if (ACTION_CREATE.equals(type)){
                view = "/views/admin/news/edit.jsp";
            }
            List<CategoryModel> categoryModelList = categoryService.findAllCategory();
            req.setAttribute("categoryList", categoryModelList);
        } else {
            view = "/views/admin/news/list.jsp";
        }

        RequestDispatcher rs = req.getRequestDispatcher(view);
        rs.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


    private boolean isNotNull(Object object) {
        return object != null;
    }

    private boolean isEmpty(String string) {
        return EMPTY.equals(string);
    }

    //category: controller, api, jsp
    //user: cntroll, api, jsp
    //role:..
    //duyet bai viet,pulish
}
