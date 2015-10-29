package com.troshchuk.javaeelabs.lab1.utils;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/PhotoLibrary");
        dataSource.setUsername("root");
        dataSource.setPassword("");
    }

    private DatabaseConnection() {
        //
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
