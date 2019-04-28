package service.impl;

import dao.INewsDAO;
import dao.impl.NewsDAOimpl;
import model.NewsModel;
import model.UserModel;
import service.INewsService;
import utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class NewsServiceImpl implements INewsService {
    private INewsDAO newsDAO;

    public NewsServiceImpl() {
        newsDAO = new NewsDAOimpl();
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
        newsModel.setStatus(newsModel1.getStatus());
        newsDAO.updateNews(newsModel.getId(), newsModel);
    }

    @Override
    public void deleteNews(HttpServletRequest request, long id) {

    }

    @Override
    public List<NewsModel> findAll() {
        return newsDAO.getAllNewsModel();
    }

    @Override
    public NewsModel findNewsByID(long id) {
        return newsDAO.findByID(id);
    }
}
