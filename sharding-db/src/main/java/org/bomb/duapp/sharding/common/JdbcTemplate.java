package org.bomb.duapp.sharding.common;

import java.sql.*;

public class JdbcTemplate {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/local";

    private static final String name = "com.mysql.jdbc.Driver";

    private static final String username = "root";

    private static final String password = "123456";

    private Connection connection;

    private PreparedStatement preparedStatement;

    public JdbcTemplate(String sql) {
        try {
            Class.forName(name);
            this.connection = DriverManager.getConnection(url, username, password);
            this.preparedStatement = connection.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String executionQuery() {
        try {
            ResultSet resultSet = this.preparedStatement.executeQuery();
            return resultSet.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    private void close() {
        try {
            if (null != this.connection)
                this.connection.close();
            if (null != preparedStatement)
                this.preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
