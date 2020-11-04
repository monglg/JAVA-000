package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class HttpRequestFilterChain {
    List<HttpRequestFilter>  filters = new CopyOnWriteArrayList<>();

    int currIndex = 0;

    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) throws Exception {
        if (filters.isEmpty()) {
            return;
        }

        if (currIndex == 0) {
            currIndex++;
            filters.get(0).filter(this, fullRequest, ctx);
        } else if (currIndex > filters.size() - 1) {
            return;
        } else {
            currIndex++;
            filters.get(currIndex - 1).filter(this, fullRequest, ctx);
        }
    }

   public  void setFilters(List<HttpRequestFilter>  filters){
        this.filters.addAll(filters);
    }

}
