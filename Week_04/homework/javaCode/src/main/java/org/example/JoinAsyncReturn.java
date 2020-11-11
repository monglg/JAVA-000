package org.example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-11-11
 * @Time: 上午9:04
 */
public class JoinAsyncReturn {

    static volatile int success = 0;
    public static void main(String[] args) throws InterruptedException {
        final Map<String, String> result= new ConcurrentHashMap<>();
        System.out.println ("start a thread");
        Thread thread = new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    result.put("result", "结果");
                    success = 1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();

        System.out.print(result.get("result"));
    }
}
