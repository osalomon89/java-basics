package com.example.springBoot;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

public class Config {
    @Configuration
    public class DataSourceConfig {
        @Bean
        public DataSource getDataSource() {
            return DataSourceBuilder.create()
                    .driverClassName("com.mysql.cj.jdbc.Driver")
                    .url("jdbc:mysql://localhost:3306/product")
                    .username("root")
                    .password("secret")
                    .build();
        }
    }
}
