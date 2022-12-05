package _10_nio.demo01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
        socketChannel.configureBlocking(false);

        ByteBuffer buffer=ByteBuffer.allocate(1024);
        buffer.put("hello hansing".getBytes());
        buffer.flip();
        socketChannel.write(buffer);
        socketChannel.close();
    }
}
