package com.example.demo2.controller;

import com.example.demo2.dao.domain.OrderInfo;
import com.example.demo2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;


@RestController
@RequestMapping("/v1/base")
public class BaseController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/test-read" ,method = {RequestMethod.GET})
    public String testRead() {
        return orderService.getOrderById(1).toString();
    }

    @RequestMapping(value = "/test-write" ,method = {RequestMethod.GET})
    public String testWrite() {
        Date currDate = new Date();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCustomerId("1");
        orderInfo.setOrderNo("111");
        orderInfo.setLogisticsInfoNo("1");
        orderInfo.setPayInfoNo("");
        orderInfo.setCreateTime(currDate);
        orderInfo.setUpdateTime(currDate);
        orderInfo.setTotalPrice(BigDecimal.TEN);
        orderInfo.setActualPrice(BigDecimal.TEN);
        orderService.saveOrderInfo(orderInfo);
        return "";
    }
}
