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
public class TokenRequestFilter extends OrderRequestFilter {

    @Override
    public void filter(HttpRequestFilterChain chain, FullHttpRequest fullRequest, ChannelHandlerContext ctx) throws Exception {
        HttpHeaders headers = fullRequest.headers();
        String token = headers.get(Constant.HEADER_USER_TOKEN);
        if (verifiedToken(token)) {
            chain.filter(fullRequest, ctx);
        } else {
            new Exception("TokenRequestFilter verifiedToken fail  token no match");
        }
    }

    private boolean verifiedToken(String token) {
//        // verifiy token
//        if ("c0a59be944724bc79f94e0fab12302f1".equals(token)) {
//               return true;
//        } else {
//            return false;
//        }
        return true;
    }

}
