package com.example.demo.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-11-18
 * @Time: 下午1:21
 */
public class LogInvocationHandler implements InvocationHandler {


    private Object object;

    public LogInvocationHandler(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        preInvoke(proxy, method, args);

        Object result = method.invoke(object, args);

        postInvoke(proxy, method, args);
        return result;
    }

    public void preInvoke(Object proxy, Method method, Object[] args){
        System.out.println("打印前 逻辑处理");
    }


    public void postInvoke(Object proxy, Method method, Object[] args){
        System.out.println("打印后 逻辑处理");
    }
}
