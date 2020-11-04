package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-11-03
 * @Time: 下午2:42
 */
public class OrderRequestFilter implements HttpRequestFilter {

    static final int PRIORITY_DEFAULT = 1;

    private int priority = PRIORITY_DEFAULT;

    @Override
    public void filter(HttpRequestFilterChain chain, FullHttpRequest fullRequest, ChannelHandlerContext ctx) throws Exception {
        chain.filter(fullRequest, ctx);
    }

    public final void setPriority(int level){
        this.priority = level;
    }
}
