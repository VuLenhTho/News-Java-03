package dao.impl;

import dao.IGenericDAO;
import mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbtractDAO<T> implements IGenericDAO<T> {
    private String url = "jdbc:mysql://localhost:3306/newsmvc";
    private String user = "root";
    private String password = "1234";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    public void insert(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            setParameter(ps, parameters);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<T> findByProperties(String sql, RowMapper<T> mapper, Object... parameters) {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> results = new ArrayList<T>();
        try {
            ps = connection.prepareStatement(sql);
            setParameter(ps, parameters);
            rs = ps.executeQuery();
            while (rs.next()) {
                T object = mapper.map(rs);
                results.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    private void setParameter(PreparedStatement ps, Object... parameter) throws SQLException {
        for (int i = 0; i < parameter.length; i++) {
            int index = i + 1;
            if (parameter[i] instanceof String) {
                ps.setString(index, (String) parameter[i]);
            } else if (parameter[i] instanceof Long) {
                ps.setLong(index, (Long) parameter[i]);
            } else if (parameter[i] instanceof Integer) {
                ps.setInt(index, (Integer) parameter[i]);
            } else if (parameter[i] instanceof Boolean) {
                ps.setBoolean(index, (Boolean) parameter[i]);
            } else if (parameter[i] instanceof Timestamp) {
                ps.setTimestamp(index, (Timestamp) parameter[i]);
            }
        }
    }
}
