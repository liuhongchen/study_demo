package netty._01_simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;


/* 自定义一个Handler需要继承Netty规定好的某个handlerAdapter */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {


    /**
     * 通道就绪就会触发该方法
     * @param ctx 上下文
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client "+ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,server",CharsetUtil.UTF_8));
    }


    /**
     * 当通道有读取时间时触发
     * @param ctx 上下文信息，包含：管道、通道、连接地址等
     * @param msg 服务端发送的数据，默认是Object
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server ctx:"+ctx);

        // 将msg转成一个ByteBuf。是netty提供的，不是nio提供的。不一样
        ByteBuf byteBuf=(ByteBuf)msg;//这个性能更高

        System.out.println("服务端发送消息："+byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("服务端地址："+ctx.channel().remoteAddress());

    }

    /**
     * 处理异常，一般是关闭通道
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
