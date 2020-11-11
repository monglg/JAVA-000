package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-11-11
 * @Time: 上午9:04
 */
public class CountDownLatchAsyncReturn {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Map<String, String> result= new ConcurrentHashMap<>();
        System.out.println ("start a thread");
        Thread thread = new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    result.put("result", "结果");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        countDownLatch.await();
        System.out.println(result.get("result"));
    }
}
