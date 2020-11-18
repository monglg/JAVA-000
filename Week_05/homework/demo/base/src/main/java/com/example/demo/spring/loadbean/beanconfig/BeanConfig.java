package com.example.demo.spring.loadbean.beanconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-11-18
 * @Time: 下午2:54
 */
@Configuration
public class BeanConfig {

    @Bean
    public Wheel getWheel(@Value("${beanload.wheel.shape: }") String shape){
        Wheel wheel = new Wheel();
        wheel.setShape(shape);
        return wheel;
    }

    @Bean
    public Body getBody(@Value("${beanload.body.colour:}") String colour ){
        Body body = new Body();
        body.setColour(colour);
        return body;
    }

    @Bean
    public Car getCar(@Autowired Wheel wheel, @Autowired Body body){
        Car car = new Car();
        car.setBody(body);
        car.setWheel(wheel);
        return car;
    }
}
