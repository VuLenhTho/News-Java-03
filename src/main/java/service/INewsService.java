package service;

import model.NewsModel;
import model.UserModel;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface INewsService {
    void insertNews(HttpServletRequest request, NewsModel newsModel);

    void updateNews(HttpServletRequest request, NewsModel newsModel);

    void deleteNews(HttpServletRequest request, long id);

    List<NewsModel> findAll(UserModel userModel);

    NewsModel findNewsByID(long id);

    void deleteNews(List<Long> ids);
}
