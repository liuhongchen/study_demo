package netty._04_groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {

    //定义一个channel组，管理所有的channel
    //GlobalEventExecutor.INSTANCE 是 全局执行器，是一个单例
    private static ChannelGroup channelGroup
            = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    //一旦建立连接，第一个被执行
    //这里要将当前channel加入到channelGroup
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //将该客户加入的消息推送给其他客户端，不需要自己遍历
        channelGroup.writeAndFlush("[客户端]"+channel.remoteAddress()+"加入聊天\n");

        channelGroup.add(channel);

    }

    //表示channel处于活动状态，提示xx上线
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"开始活跃");
    }

    //表示channel处于不活动状态
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"处于不活跃状态");
    }

    //表示channel处于断开连接，提示xx离线
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        //channelGroup.remove(ctx.channel()); 会自动移除
        channelGroup.writeAndFlush("[客户端]"+ctx.channel().remoteAddress()+"退出聊天\n");

    }

    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        final Channel channel = ctx.channel();
        channelGroup.forEach(ch->{
            if (channel!=ch){
                ch.writeAndFlush("[客户端]"+channel.remoteAddress()+"说:"+msg+"\n");
            }else {
                ch.writeAndFlush("[消息发送成功]");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
