package com.example.demo2.config.mybatis;

import com.example.demo2.config.ThreadLocalContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-12-02
 * @Time: 下午2:21
 */
public class CustomRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return ThreadLocalContextHolder.getSelectedDbKey();
    }
}
