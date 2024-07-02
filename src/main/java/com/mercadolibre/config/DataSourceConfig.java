package com.mercadolibre.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private static final String DATA_SOURCE_URL = "jdbc:mysql://%s/%s?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

    private static final Integer POOL_SIZE = 100;

//    @Bean
//    @Profile({"!local"})
//    public DataSource getDataSource(
//            final @Value("${datasource.driver-class-name}") String driver,
//            final @Value("${datasource.url}") String jdbcUrl,
//            final @Value("${datasource.db}") String db,
//            final @Value("${datasource.user}") String user,
//            final @Value("${datasource.password}") String password) {
//        return buildDataSource(driver, FuryUtils.getEnv(jdbcUrl), db, user, FuryUtils.getEnv(password));
//    }

    @Bean
    @Profile("local")
    public DataSource getDataSourceLocal(
            final @Value("${datasource.driver-class-name}") String driver,
            final @Value("${datasource.url}") String jdbcUrl,
            final @Value("${datasource.db}") String db,
            final @Value("${datasource.user}") String user,
            final @Value("${datasource.password}") String password) {

        return buildDataSource(driver, jdbcUrl, db, user, password);
    }

    private DataSource buildDataSource(
            String driver, String jdbcUrl, String db, String user, String password) {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(String.format(DATA_SOURCE_URL, jdbcUrl, db));
        config.setUsername(user);
        config.setPassword(password);
        config.setMaximumPoolSize(POOL_SIZE);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        return new HikariDataSource(config);
    }
}

