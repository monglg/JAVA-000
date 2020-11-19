package com.example.demo.config;

import com.example.demo.jdbc.DataBaseUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
