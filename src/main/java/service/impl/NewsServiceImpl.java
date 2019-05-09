package service.impl;

import dao.INewsDAO;
import dao.IRoleDAO;
import dao.impl.NewsDAOimpl;
import dao.impl.RoleDAOimpl;
import model.NewsModel;
import model.RoleModel;
import model.UserModel;
import service.INewsService;
import service.IRoleService;
import utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class NewsServiceImpl implements INewsService {
    private INewsDAO newsDAO;
    private IRoleDAO roleDAO;

    public NewsServiceImpl() {
        newsDAO = new NewsDAOimpl();
        roleDAO = new RoleDAOimpl();
    }

    @Override
    public void insertNews(HttpServletRequest request, NewsModel newsModel) {
        Date date = new Date();
        newsModel.setCreatedDate(new Timestamp(date.getTime()));
        UserModel userModel = (UserModel) SessionUtil.getValue(request,"USER");
        newsModel.setCreatedBy(userModel.getUserName());
        newsModel.setStatus("PENDING");
        newsDAO.insertNews(newsModel);
    }

    @Override
    public void updateNews(HttpServletRequest request, NewsModel newsModel) {
        NewsModel newsModel1 = newsDAO.findByID(newsModel.getId());
        Date date = new Date();
        newsModel.setCreatedDate(newsModel1.getCreatedDate());
        newsModel.setCreatedBy(newsModel1.getCreatedBy());
        newsModel.setModifiedDate(new Timestamp(date.getTime()));
        UserModel userModel = (UserModel) SessionUtil.getValue(request,"USER");
        newsModel.setModifiedBy(userModel.getUserName());
        newsDAO.updateNews(newsModel.getId(), newsModel);
    }

    @Override
    public void deleteNews(HttpServletRequest request, long id) {

    }

    @Override
    public List<NewsModel> findAll(UserModel userModel) {
        String creator = null;
        RoleModel roleModel = roleDAO.findRoleById(userModel.getRoleID());
        if (roleModel.getRoleName().equals("admin")){
            return newsDAO.getAllNewsModel(creator);
        }else if (roleModel.getRoleName().equals("editor")){
            return newsDAO.getAllNewsModel(userModel.getUserName());
        }
        return null;
    }

    @Override
    public NewsModel findNewsByID(long id) {
        return newsDAO.findByID(id);
    }

    @Override
    public void deleteNews(List<Long> ids) {
        for (Long id: ids) {
            newsDAO.deleteNews(id);
        }
    }

}
