package io.github.kimmking.gateway.outbound.netty4;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultHttpResponse;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-11-03
 * @Time: 下午5:12
 */

public class HttpClientOutboundHandler extends ChannelInboundHandlerAdapter {

    private PendingCenter pendingCenter;

    public HttpClientOutboundHandler(PendingCenter pendingCenter) {
        this.pendingCenter = pendingCenter;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        DefaultHttpResponse response = (DefaultHttpResponse) msg;
        if (pendingCenter != null) {
            pendingCenter.fillRequest("12345", response);
        }
    }

}
