package dao;

import model.NewsModel;

import java.util.List;

public interface INewsDAO extends IGenericDAO<NewsModel> {
    void insertNews(NewsModel newsModel);

    List<NewsModel> getAllNewsModel(String creator);

    void updateNews(Long id, NewsModel updateModel);

    NewsModel findByID(Long id);

    void deleteNews(Long id);
}
