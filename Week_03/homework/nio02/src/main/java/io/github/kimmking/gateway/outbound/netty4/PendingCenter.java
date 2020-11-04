package io.github.kimmking.gateway.outbound.netty4;

import io.netty.handler.codec.http.DefaultHttpResponse;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-11-04
 * @Time: 下午1:57
 */
public class PendingCenter {

    private Map<String, CallFuture> callIngTable = new ConcurrentHashMap<>();

    public void addPending(String trackId, CallFuture future){
        callIngTable.put(trackId, future);
    }

    public void fillRequest(String trackId, DefaultHttpResponse response) {
        CallFuture future = callIngTable.get(trackId);
        if (future != null) {
            future.setSuccess(response);
            callIngTable.remove(trackId);
        }

    }
}
