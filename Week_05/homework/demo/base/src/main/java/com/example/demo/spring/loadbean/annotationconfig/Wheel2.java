package com.example.demo.spring.loadbean.annotationconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-11-18
 * @Time: 下午2:57
 */
@Component
public class Wheel2 {

    @Value("${beanload.wheel.shape: }")
    private String shape;
}
