package com.nemchann.employyes_departments.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

@Configuration
public class DatabaseConfig {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public Connection connection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }
}
