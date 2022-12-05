package _10_nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {

    public static void main(String[] args) {

        String path="./channel_text.txt";
        try {
            FileInputStream fis=new FileInputStream(path);
            FileChannel fileChannel=fis.getChannel();
            ByteBuffer buffer=ByteBuffer.allocate(1024);
            fileChannel.read(buffer);//byteBuffer默认是写模式

            buffer.flip();//要读数据了，切换为读模式
            byte[] bytes=new byte[3];
            buffer.get(bytes);
            System.out.println(new String(bytes));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
