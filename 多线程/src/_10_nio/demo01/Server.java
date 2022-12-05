package _10_nio.demo01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server {

    public static void main(String[] args) throws IOException {

        // 1.获取选择器
        Selector selector = Selector.open();

        // 2.获取通道。创建这个channel的目的主要是为了接收客户端的请求，建立新通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);//切换为非阻塞模式
        serverSocketChannel.bind(new InetSocketAddress(9999));//绑定连接端口

        // 3.将Channel注册到Selector上，并且指定 监听事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 4.使用Selector轮询已经就绪的事件
        while (selector.select() > 0) {

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey sk = iterator.next();

                if (sk.isAcceptable()) {//如果是建立连接事件
                    SocketChannel socketChannel = serverSocketChannel.accept();//建立连接
                    socketChannel.configureBlocking(false);
                    //将客户端的通道注册为读事件，register方法返回SelectionKey，里面封装通道和事件
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {//如果是读事件
                    SocketChannel socketChannel = (SocketChannel) sk.channel();//强转并读数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = socketChannel.read(buffer)) > 0) {
                        buffer.flip();
                        System.out.println("获取到数据：" + new String(buffer.array(), 0, len));
                        buffer.clear();
                    }
                    socketChannel.close();
                    System.out.println("结束");
                }
                iterator.remove();
            }

        }

    }

}
