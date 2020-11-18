package com.example.demo.proxy.dynamic.cglib;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-11-18
 * @Time: 下午1:21
 */
public class LogInvocationHandler implements MethodInterceptor {


    public void preInvoke(Object o, Method method, Object[] args){
        System.out.println("打印前 逻辑处理");
    }

    public void postInvoke(Object o, Method method, Object[] args){
        System.out.println("打印后 逻辑处理");
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        preInvoke(0, method, objects);
        Object result = methodProxy.invokeSuper(o, objects);
        postInvoke(0, method, objects);
        return result;
    }
}
