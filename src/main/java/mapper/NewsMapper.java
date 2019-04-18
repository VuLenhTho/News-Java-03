package mapper;

import model.NewsModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsMapper implements RowMapper<NewsModel> {
    public NewsModel map(ResultSet rs) throws SQLException {
        NewsModel newsModel = new NewsModel();
        newsModel.setId(rs.getLong("id"));
        if (rs.getString("title") != null) {
            newsModel.setTitle(rs.getString("title"));
        }
        if (rs.getString("shortDescription") != null) {
            newsModel.setShortDescription(rs.getString("shortDescription"));
        }
        if (rs.getString("content") != null) {
            newsModel.setContent(rs.getString("content"));
        }
        if (rs.getString("createdBy") != null) {
            newsModel.setCreatedBy(rs.getString("createdBy"));
        }

        if (rs.getString("modifiedBy") != null) {
            newsModel.setModifiedBy(rs.getString("modifiedBy"));
        }

        if (rs.getString("censor") != null) {
            newsModel.setCensor(rs.getString("censor"));
        }
        if (rs.getString("thumbnail") != null) {
            newsModel.setthumbnail(rs.getString("thumbnail"));
        }
        if (rs.getString("status") != null) {
            newsModel.setStatus(rs.getString("status"));
        }
        newsModel.setCategoryID(rs.getLong("categoryID"));
        try {
            if (rs.getTimestamp("modifiedDate") != null) {
                newsModel.setModifiedDate(rs.getTimestamp("modifiedDate"));
            }
            if (rs.getTimestamp("createdDate") != null) {
                newsModel.setCreatedDate(rs.getTimestamp("createdDate"));
            }
        } catch (SQLException e) {
            return newsModel;
        }
        return newsModel;
    }
}
