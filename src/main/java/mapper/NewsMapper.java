package mapper;

import model.NewsModel;
import utils.MapUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsMapper implements RowMapper<NewsModel> {
    public NewsModel map(ResultSet rs) throws SQLException {
        return MapUtil.mapRow(new NewsModel(),rs);
    }
}
