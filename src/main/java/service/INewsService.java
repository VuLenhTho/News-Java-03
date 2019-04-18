package service;

import model.NewsModel;

import javax.servlet.http.HttpServletRequest;

public interface INewsService {
    void insertNews(HttpServletRequest request, NewsModel newsModel);

    void updateNews(HttpServletRequest request, NewsModel newsModel);

    void deleteNews(HttpServletRequest request,long id);
}
