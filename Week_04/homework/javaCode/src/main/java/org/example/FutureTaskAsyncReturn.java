package org.example;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-11-11
 * @Time: 上午9:04
 */
public class FutureTaskAsyncReturn {
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException, ExecutionException {
       FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
           @Override
           public String call() throws Exception {
               Thread.sleep(1000);
               return "结果";
           }
       });
       executorService.submit(task);
       System.out.print(task.get());
       executorService.shutdown();
    }


}
