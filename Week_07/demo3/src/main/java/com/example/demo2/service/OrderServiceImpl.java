package com.example.demo2.service;

import com.example.demo2.dao.domain.OrderInfo;
import com.example.demo2.dao.mapper.OrderInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-12-03
 * @Time: 上午11:09
 */

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public OrderInfo findOrderInfo(Integer id) {
        return orderInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void createOrderInfo(OrderInfo info) {
        orderInfoMapper.insertSelective(info);
    }
}
