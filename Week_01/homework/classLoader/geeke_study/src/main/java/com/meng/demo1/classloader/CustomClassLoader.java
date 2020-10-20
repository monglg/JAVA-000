package com.meng.demo1.classloader;

import sun.misc.Resource;
import sun.misc.URLClassPath;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-10-19
 * @Time: 下午4:29
 */
public class CustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
           File file = new File("/Users/admin/Downloads/Hello/Hello.xlass");
           InputStream in = new FileInputStream(file);
           byte[] source = new byte[(int)file.length()];
           in.read(source, 0, (int)file.length());
           byte[] target = new byte[source.length];
           for (int i = 0 ; i< source.length ;i++){
               target[i] = (byte)(255 - source[i]);
           }
           return defineClass(name, target, 0, target.length);
        } catch (Exception e){

        }

        return null;
    }

}
