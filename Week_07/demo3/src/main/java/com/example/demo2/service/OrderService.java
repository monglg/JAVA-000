package com.example.demo2.service;

import com.example.demo2.dao.domain.OrderInfo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-12-03
 * @Time: 上午11:09
 */
public interface OrderService {

    OrderInfo findOrderInfo(Integer id);

    void createOrderInfo(OrderInfo info);
}
