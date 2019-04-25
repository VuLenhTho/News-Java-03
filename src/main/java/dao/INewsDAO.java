package dao;

import model.NewsModel;

import java.util.List;

public interface INewsDAO extends IGenericDAO<NewsModel>{
    void insertNews(NewsModel newsModel);

    List<NewsModel> getAllNewsModel();

    void updateNews(Long id, NewsModel updateModel);

    NewsModel findByID(Long id);


}
