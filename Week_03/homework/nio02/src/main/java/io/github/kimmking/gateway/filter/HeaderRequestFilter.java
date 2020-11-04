package io.github.kimmking.gateway.filter;

import io.github.kimmking.gateway.utils.Constant;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-11-03
 * @Time: 下午2:24
 */
public class HeaderRequestFilter extends OrderRequestFilter {

    @Override
    public void filter(HttpRequestFilterChain chain, FullHttpRequest fullRequest, ChannelHandlerContext ctx) throws Exception {
        HttpHeaders headers = fullRequest.headers();
        headers.add(Constant.HEADER_NIO, "mlg");
        chain.filter(fullRequest, ctx);
    }
}
