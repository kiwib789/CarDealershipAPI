package com.pluralsight.dealership.CarDealershipAPI;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConfig {
    public static BasicDataSource dataSource;

    public static BasicDataSource getDataSource(String url, String userName, String password) {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(url);
            dataSource.setUsername(userName);
            dataSource.setPassword(password);
        }
        return dataSource;
    }

    public static Connection getConnection(String url, String userName, String password) throws SQLException {
        return getDataSource(url, userName, password).getConnection();
    }

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/cardealership");
        dataSource.setUsername("Keely");
        dataSource.setPassword("yearup");
        return dataSource;


    }
}
