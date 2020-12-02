package com.example.demo2.config;

import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-12-02
 * @Time: 下午2:26
 */
public class ThreadLocalContextHolder {

    public static final String DB_WRITE = "write";

    public static final String DB_READ= "read_";

    private static ThreadLocal<String> selectedDbKey = new ThreadLocal<>();

    public static void setSelectedDbKey(String key) {
        if (key == null) {
            selectedDbKey.remove();
            return ;
        }
        selectedDbKey.set(key);
    }

    public static String getSelectedDbKey(){
        return selectedDbKey.get() == null ? DB_WRITE : selectedDbKey.get();
    }

}
