package netty._01_simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {


    public static void main(String[] args) throws InterruptedException {


        //创建bossGroup和workerGroup，两个都是无限循环
        EventLoopGroup bossGroup = new NioEventLoopGroup();//只处理连接请求
        EventLoopGroup workerGroup = new NioEventLoopGroup();//与客户端交互 读写

        try {
            //创建服务器端启动对象，去配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)//服务器使用的accept通道
                    .option(ChannelOption.SO_BACKLOG, 128)//设置线程队列得到连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)//设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //创建一个通道测试对象
                        //给workerGroup的EventLoop对应的pipeline设置处理器
                        protected void initChannel(SocketChannel channel) throws Exception {
                            //channel和pipeline之间可以互相拿到
                            channel.pipeline().addLast(new NettyServerHandler());
                        }
                    });

            //指定服务器端口并启动服务器,同步处理，生成一个channelFuture对象
            ChannelFuture channelFuture = bootstrap.bind(6668).sync();


            //对关闭通道进行监听，监听到关闭通道的事件之后才会进行处理（Netty异步模型）
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }
}
