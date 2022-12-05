package netty._01_simple;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;


/* 自定义一个Handler需要继承Netty规定好的某个handlerAdapter */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {



    /**
     * 读取数据（客户端发送的消息）
     * @param ctx 上下文信息，包含：管道、通道、连接地址等
     * @param msg 客户端发送的数据，默认是Object
     * @throws Exception
     */
    @Override
    public void channelRead(final ChannelHandlerContext ctx, Object msg) throws Exception {

        ctx.writeAndFlush(Unpooled.copiedBuffer("hello客户端1",CharsetUtil.UTF_8));

        //如果这里有一个耗时非常长的任务-》异步执行-》提交该channel对应的
        //NioEventLoop到TaskQueue中

        //解决方案1 用户程序自定义普通任务,这应该就加到队列，然后会串行执行
        // 一个休眠10秒，一个休眠20秒，一共需要花费30秒，是串行执行，不是开线程执行
        //即 taskQueue中的任务是串行执行的
//        ctx.channel().eventLoop().execute(new Runnable() {
//            public void run() {
//                try {
//                    Thread.sleep(10 * 1000L);//不异步的话客户端会阻塞
//
//                } catch (InterruptedException e) {
//                    System.out.println("发生异常"+e.getCause());
//                }
//
//                ctx.writeAndFlush(Unpooled.copiedBuffer("hello客户端2",CharsetUtil.UTF_8));
//
//            }
//        });


        // 解决方案2 提交到ScheduleTaskQueue中,5秒后执行
        // 如果时间到了，taskQueue中的任务正在执行怎么办
        ctx.channel().eventLoop().schedule(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10 * 1000L);//不异步的话客户端会阻塞

                } catch (InterruptedException e) {
                    System.out.println("发生异常" + e.getCause());
                }

                ctx.writeAndFlush(Unpooled.copiedBuffer("hello客户端2", CharsetUtil.UTF_8));

            }
        },5, TimeUnit.SECONDS);

        System.out.println("go on");


    }

    /**
     * 读取数据完毕后的处理
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        // 将数据写入到缓存 并刷新
//        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端",CharsetUtil.UTF_8));

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
