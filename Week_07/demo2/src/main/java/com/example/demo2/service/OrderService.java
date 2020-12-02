package com.example.demo2.service;

import com.example.demo2.dao.domain.OrderInfo;

public interface OrderService {

    /**
     * 获取订单信息
     * @return
     */
    OrderInfo getOrderById(Integer id);

    /**
     * 添加订单
     * @param info
     */
    void saveOrderInfo(OrderInfo info);
}
