package _10_nio.demo02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class NioClient {

    private Selector selector;
    private SocketChannel socketChannel;

    public NioClient() {
        try {
            selector = Selector.open();

            socketChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",9999));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector,SelectionKey.OP_READ);
            System.out.println("客户端准备完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readInfo() {
        try {
            while (selector.select() > 0) {

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey sk = iterator.next();
                    if (sk.isReadable()) {
                        SocketChannel channel = (SocketChannel) sk.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int len = channel.read(buffer);
                        if (len < 0) return;
                        String msg=new String(buffer.array(),0,buffer.remaining());
                        System.out.println("client 收到消息："+msg);
                    }

                    iterator.remove();
                }

            }
        } catch (IOException e) {

        }

    }

    public static void main(String[] args) throws IOException {


        NioClient client = new NioClient();

        new Thread(client::readInfo).start();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = Thread.currentThread().getName()+"说:"+sc.nextLine();
            buffer.put(s.getBytes());
            buffer.flip();
            client.socketChannel.write(buffer);
            buffer.clear();
        }

    }
}
