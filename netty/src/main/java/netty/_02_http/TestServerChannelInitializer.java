package netty._02_http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;


public class TestServerChannelInitializer extends ChannelInitializer<SocketChannel> {


    protected void initChannel(SocketChannel ch) throws Exception {
        //得到管道
        ChannelPipeline pipeline = ch.pipeline();

        //1. 向管道加入netty提供的httpServer编解码器 httpServerCodec
        pipeline.addLast("MyHttpServerCodec",new HttpServerCodec());

        //2. 增加自定义的handler
        pipeline.addLast("MyHttpServerHandler",new TestHttpServerHandler());

    }
}
