package com.bruno13palhano;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class ConnectionFactory {
    private static volatile Connection INSTANCE;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public Connection getConnection() {
        if (INSTANCE == null) {
            synchronized (ConnectionFactory.class) {
                if (INSTANCE == null) {
                    try {
                        INSTANCE = DriverManager.getConnection(url, username, password);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return INSTANCE;
    }
}
