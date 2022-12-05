package netty._01_simple;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {


    public static void main(String[] args) throws InterruptedException {
        //客户端需要一个EventLoopGroup
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();

        //创建客户端启动对象
        Bootstrap bootstrap = new Bootstrap();

        try {
            //给bootstrap设置相关参数
            bootstrap.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline().addLast(new NettyClientHandler());//加入处理器
                        }
                    });

            System.out.println("客户端准备好了");


            //启动客户端去连接服务器
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6668).sync();

            //给关闭通道进行监听
            channelFuture.channel().closeFuture().sync();//非阻塞

        }finally {
            eventExecutors.shutdownGracefully();
        }

    }
}
