package io.github.kimmking.gateway.outbound.netty4;

import io.github.kimmking.gateway.outbound.CustomOutboundHandler;
import io.github.kimmking.gateway.outbound.NamedThreadFactory;
import io.github.kimmking.gateway.utils.Constant;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.RejectedExecutionHandler;

public class NettyHttpClientOutboundHandler implements CustomOutboundHandler{

    Bootstrap client = null;

    private ExecutorService proxyService;

    private Map<String, Channel> activeChannelTable = new ConcurrentHashMap<>();

    private PendingCenter pendingCenter = new PendingCenter();

    public NettyHttpClientOutboundHandler() {

        int cores = Runtime.getRuntime().availableProcessors() * 2;
        long keepAliveTime = 1000;
        int queueSize = 2048;

        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();//.DiscardPolicy();
        proxyService = new ThreadPoolExecutor(cores, cores,
                keepAliveTime, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(queueSize),
                new NamedThreadFactory("proxyService"), handler);

        EventLoopGroup workerGroup = new NioEventLoopGroup();
        client = new Bootstrap();
        client.group(workerGroup);
        client.channel(NioSocketChannel.class);
        client.option(ChannelOption.SO_KEEPALIVE, true);
        client.handler(new ChannelInitializer<SocketChannel>() {

            @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new HttpResponseDecoder());
                    ch.pipeline().addLast(new HttpRequestEncoder());
                    ch.pipeline().addLast(new HttpClientOutboundHandler(pendingCenter));
                }
            });
    }

    @Override
    public void handle(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        String serverId = fullRequest.headers().get(Constant.INNER_HEADER_ROUTER);

        // get backEnd server list
        List<String> backEndServers = fetchBackEndServers(serverId);
        // select one backend server
        String serverHost = selectOneServer(backEndServers);

        proxyService.submit(() -> callRemote(fullRequest, ctx, serverHost));
    }

    private void callRemote(FullHttpRequest fullRequest, ChannelHandlerContext ctx, String serverHost){
        // get or create one channel
        Channel channel = getOrCreateChannelByServerHost(serverHost);
        if (channel == null || !channel.isActive()) {

        }
        HttpRequest request = new DefaultHttpRequest(fullRequest.protocolVersion(), fullRequest.method(), fullRequest.uri());

        fullRequest.headers().remove(Constant.INNER_HEADER_ROUTER);
        request.headers().add(fullRequest.headers());

        String trackId = request.headers().get(Constant.INNER_HEADER_TRACKID);

        CallFuture callFuture = new CallFuture();
        ChannelFuture future = channel.writeAndFlush(request);
        future.addListener(new ChannelFutureListener(){
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    pendingCenter.addPending(trackId, callFuture);
                  System.out.print("send message success");
                }
            }
        });

        try {
            DefaultHttpResponse response = callFuture.get();
            ctx.writeAndFlush(response);
            ctx.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private Channel getOrCreateChannelByServerHost(String serverHost) {
       try {
           Channel channel = activeChannelTable.get(serverHost);
           if (channel == null || !channel.isActive()) {
               URI uriSimple = new URI(serverHost);
               String host = uriSimple.getHost() == null? "127.0.0.1" : uriSimple.getHost();
               int port = uriSimple.getPort();
               channel = client.connect(host, port).sync().channel();
           }
           return channel;
       } catch (InterruptedException e) {
           e.printStackTrace();
       } catch (URISyntaxException e) {
           e.printStackTrace();
       }

       return null;
    }

    private String selectOneServer(List<String> backEndServers) {
        return  backEndServers.get(0);
    }

    private List<String> fetchBackEndServers(String serverId) {
        List<String> backEndServers = new ArrayList<>();
        if ("test1".equals(serverId)) {
            backEndServers.add("http://127.0.0.1:8801");
        }
        if ("test2".equals(serverId)) {
            backEndServers.add("http://127.0.0.1:8802");
            backEndServers.add("http://127.0.0.1:8803");
        }
        return backEndServers;
    }

//    class CustomHttpClientOutboundHandler extends ChannelInboundHandlerAdapter {
//        @Override
//        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//                   faf
//        }
//
//    }
}