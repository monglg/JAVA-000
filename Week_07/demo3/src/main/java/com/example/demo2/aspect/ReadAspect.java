package com.example.demo2.aspect;

import com.example.demo2.config.ThreadLocalContextHolder;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReadAspect {

    private static final Logger logger = LoggerFactory.getLogger(ReadAspect.class);

    @Pointcut("@annotation(com.example.demo2.aspect.Read)")
    public void pointcut(){

    }
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        ThreadLocalContextHolder.setSelectedDbKey(ThreadLocalContextHolder.DB_READ);
        return joinPoint.proceed();
    }

}
