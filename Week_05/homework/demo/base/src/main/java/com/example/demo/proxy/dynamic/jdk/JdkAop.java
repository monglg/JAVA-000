package com.example.demo.proxy.dynamic.jdk;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-11-18
 * @Time: 下午1:18
 */
public class JdkAop {

    public static void main(String[] args) {

        LogInvocationHandler invocationHandler = new LogInvocationHandler(new MobileScreenPrint());

        IScreenPrint screenPrint = (IScreenPrint)Proxy.newProxyInstance(MobileScreenPrint.class.getClassLoader(), new Class[]{IScreenPrint.class}, invocationHandler);

        screenPrint.show();
    }
}
