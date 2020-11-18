package com.example.demo.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-11-18
 * @Time: 下午2:09
 */
public class CglibAop {
    public static void main(String[] args) {
        LogInvocationHandler handler = new LogInvocationHandler();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ScreenPrint.class);
        enhancer.setCallback(handler);

        ScreenPrint screenPrint = (ScreenPrint) enhancer.create();
        screenPrint.show();
    }
}
