package com.example.demo2.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.demo2.config.mybatis.CustomRoutingDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-12-02
 * @Time: 下午2:12
 */


@Configuration
public class AppConfig {

    @Bean
    @ConfigurationProperties(prefix = "mysql.datasource.write")
    public DataSource getMasterSource() {
        return new DruidDataSource();

    }

    @Bean
    @ConfigurationProperties(prefix = "mysql.datasource.read")
    public DataSource getReadSource() {
        return new DruidDataSource();

    }

    @Bean
    @Primary
    public DataSource getRoutingDataSource() {
        CustomRoutingDataSource customRoutingDataSource = new CustomRoutingDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(ThreadLocalContextHolder.DB_WRITE, getMasterSource());
        dataSourceMap.put(ThreadLocalContextHolder.DB_READ, getReadSource());
        customRoutingDataSource.setTargetDataSources(dataSourceMap);
        customRoutingDataSource.setDefaultTargetDataSource(getMasterSource());
        return customRoutingDataSource;
    }


}
