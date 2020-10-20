package com.meng.demo1.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-10-19
 * @Time: 下午5:27
 */
public class A {
    public static void main(String[] args) throws Exception{
        try{
            CustomClassLoader load = new CustomClassLoader();
            Class helloClass = load.findClass("Hello");
            Method[] first = helloClass.getDeclaredMethods();
            Object o = helloClass.newInstance();
            Arrays.stream(first).forEach(item -> {
                try {
                    item.invoke(o);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            });


        } catch (ClassNotFoundException e){

        }

    }
}
