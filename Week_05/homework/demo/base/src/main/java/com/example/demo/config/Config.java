package com.example.demo.config;

import com.example.demo.jdbc.DataBaseUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-11-19
 * @Time: 上午11:19
 */
@Configuration
public class Config {

    @Bean
    @ConditionalOnMissingBean
    public Connection getConnection() {
        Connection connection = DataBaseUtil.getConnection();
        DataBaseUtil.initSchema(connection);
        return connection;
    }

    @Bean
    public DataSource getDataSource(){
        HikariConfig config = new HikariConfig();
        config.setMinimumIdle(1);
        config.setMaximumPoolSize(4);
        config.setConnectionTestQuery("VALUES 1");
        config.setDriverClassName("org.h2.Driver");
        config.setJdbcUrl("jdbc:h2:mem:testdb;MODE=MYSQL;DB_CLOSE_DELAY=-1");
        config.addDataSourceProperty("user", "sa");
        config.addDataSourceProperty("password", "");
        HikariDataSource dataSource = new HikariDataSource(config);

        return dataSource;

    }
}
