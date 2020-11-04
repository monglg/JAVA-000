package io.github.kimmking.gateway.filter;

import io.github.kimmking.gateway.utils.Constant;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-11-03
 * @Time: 下午2:24
 */
public class RouterRequestFilter extends OrderRequestFilter {

    @Override
    public void filter(HttpRequestFilterChain chain, FullHttpRequest fullRequest, ChannelHandlerContext ctx) throws Exception {
        String uri = fullRequest.uri();
        String serverId = selectBarkEndServer(uri);
        HttpHeaders httpHeaders = fullRequest.headers();
        if (httpHeaders != null) {
            httpHeaders.add(Constant.INNER_HEADER_ROUTER, serverId);
        }
        String trackId = UUID.randomUUID().toString().replace("-","");
        httpHeaders.add(Constant.INNER_HEADER_TRACKID, "12345");

        chain.filter(fullRequest, ctx);
    }

    private String selectBarkEndServer(String uri){
        return "test1";
    }
}
