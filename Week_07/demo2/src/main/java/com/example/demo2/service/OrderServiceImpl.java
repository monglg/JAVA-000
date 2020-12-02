package com.example.demo2.service;

import com.example.demo2.aspect.Read;
import com.example.demo2.dao.domain.OrderInfo;
import com.example.demo2.dao.mapper.OrderInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    @Read
    public OrderInfo getOrderById(Integer id) {
        return orderInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrderInfo(OrderInfo info) {
        orderInfoMapper.insertSelective(info);
    }
}
