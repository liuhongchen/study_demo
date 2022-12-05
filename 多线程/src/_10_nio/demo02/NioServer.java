package _10_nio.demo02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class NioServer {

    // 1 定义成员属性：选择器、服务端通道、端口

    Selector selector;
    ServerSocketChannel serverSocketChannel;
    private static final int PORT = 9999;


    public NioServer() {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(PORT));

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listen() throws IOException {
        System.out.println("-----NIO Server启动，等待消息...");
        while (selector.select() > 0) {

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey sk = iterator.next();

                if (sk.isAcceptable()) {//如果是建立连接事件
                    SocketChannel socketChannel = serverSocketChannel.accept();//建立连接
                    socketChannel.configureBlocking(false);
                    //将客户端的通道注册为读事件，register方法返回SelectionKey，里面封装通道和事件
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("----client:" + socketChannel.getRemoteAddress() + "上线了！");
                } else if (sk.isReadable()) {//如果是读事件
                    readClientData(sk);
                }
                iterator.remove();
            }

        }
    }

    private void readClientData(SelectionKey sk) throws IOException {
        SocketChannel socketChannel = null;
        try {
            socketChannel = (SocketChannel) sk.channel();//强转并读数据

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int len = socketChannel.read(buffer);
            if (len < 0) return;
            buffer.flip();
            String msg = new String(buffer.array(), 0, buffer.remaining());
            System.out.println("------接收到客户端消息" + msg);

            sendMsgToAll(socketChannel, msg);

            buffer.clear();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("-----有人离线了" + socketChannel.getRemoteAddress());
            //当前客户端离线了
            sk.cancel();
            socketChannel.close();
        }
    }

    private void sendMsgToAll(SocketChannel socketChannel, String msg) throws IOException {
        System.out.println("------服务端开始转发消息");
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
        for (SelectionKey sk : selector.keys()) {
            Channel channel=sk.channel();
            if (channel==socketChannel||!(channel instanceof SocketChannel))continue;
            ((SocketChannel) channel).write(buffer);
        }
        System.out.println("------服务端转发消息完成");

    }

    public static void main(String[] args) throws IOException {
        NioServer server = new NioServer();
        server.listen();
    }

}
