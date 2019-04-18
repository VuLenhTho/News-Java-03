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

public class NewsServiceImpl implements INewsService {
    private INewsDAO newsDAO;

    public NewsServiceImpl(){
        newsDAO = new NewsDAOimpl();
    }
    @Override
    public void insertNews(HttpServletRequest request, NewsModel newsModel) {
        Date date = new Date();
        newsModel.setCreatedDate(new Timestamp(date.getTime()));
//        UserModel userModel = (UserModel) SessionUtil.getValue(request,"USER");
//        newsModel.setCreatedBy(userModel.getUserName());

        newsDAO.insertNews(newsModel);
    }

    @Override
    public void updateNews(HttpServletRequest request, NewsModel newsModel) {
        Date date = new Date();
        newsModel.setCreatedDate(new Timestamp(date.getTime()));
        newsModel.setModifiedDate(new Timestamp(date.getTime()));
        newsDAO.updateNews(newsModel.getId(),newsModel);
    }

    @Override
    public void deleteNews(HttpServletRequest request, long id) {

    }
}
