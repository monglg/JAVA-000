package com.example.demo.spring.loadbean.annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-11-18
 * @Time: 下午2:56
 */
@Component
public class Car2 {

    @Autowired
    private Body2 body;

    @Autowired
    private Wheel2 wheel;
}
