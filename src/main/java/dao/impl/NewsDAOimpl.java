package dao.impl;

import dao.INewsDAO;
import mapper.NewsMapper;
import model.NewsModel;

import java.util.List;

public class NewsDAOimpl extends AbtractDAO<NewsModel> implements INewsDAO {

    public void insertNews(NewsModel newsModel) {
        String sql = "INSERT INTO news(title, shortDescription, content, createdBy, createdDate, thumbnail, status, categoryID) VALUE (?,?,?,?,?,?,?,?)";
        insert(sql, newsModel.getTitle(), newsModel.getShortDescription(),
                newsModel.getContent(), newsModel.getCreatedBy(),
                newsModel.getCreatedDate(), newsModel.getThumbNail(),
                newsModel.getStatus(), newsModel.getCategoryID());
    }

    public List<NewsModel> getAllNewsModel(String creator) {
        String sql;
        if (creator == null){
            sql = "SELECT * FROM news";
            return findByProperties(sql, new NewsMapper());
        }else {
            sql = "SELECT * FROM news WHERE createdBy = ?";
            return findByProperties(sql, new NewsMapper(),creator);
        }

    }

    @Override
    public void updateNews(Long id, NewsModel updateModel) {
        String sql = "UPDATE news SET title=?,shortDescription=?,content=?,createdBy=?,\n" +
                "createdDate=?,modifiedBy=?,modifiedDate=?,\n" +
                "thumbnail=?,status=?,categoryID=? WHERE id=?";
        insert(sql, updateModel.getTitle(), updateModel.getShortDescription(),
                updateModel.getContent(), updateModel.getCreatedBy(),
                updateModel.getCreatedDate(), updateModel.getModifiedBy(),
                updateModel.getModifiedDate(), updateModel.getThumbNail(),
                updateModel.getStatus(), updateModel.getCategoryID(), id);
    }

    @Override
    public NewsModel findByID(Long id) {
        String sql = "SELECT * FROM news WHERE id =?";
        List<NewsModel> list = findByProperties(sql, new NewsMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void deleteNews(Long id) {
        String sql = "DELETE FROM news WHERE id = ?";
        insert(sql,id);
    }


}
