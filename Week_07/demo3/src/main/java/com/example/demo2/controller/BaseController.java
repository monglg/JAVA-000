package com.example.demo2.controller;

import com.example.demo2.dao.domain.OrderInfo;
import com.example.demo2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/base")
public class BaseController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/test-read" ,method = {RequestMethod.GET})
    public String testRead() {
        return orderService.findOrderInfo(1).toString();
    }



    @RequestMapping(value = "/test-write" ,method = {RequestMethod.GET})
    public String testWrite() {
        OrderInfo orderInfo = new OrderInfo();
        orderService.createOrderInfo(orderInfo);
        return "";
    }
}
