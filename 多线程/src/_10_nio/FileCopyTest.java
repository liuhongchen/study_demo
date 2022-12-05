package _10_nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileCopyTest {


    public static void main(String[] args) throws Exception {

        String sourcePath="C:\\download\\12.txt";
        String destPath="C:\\download\\123.txt";

        File srcFile=new File(sourcePath);

        FileInputStream fis=new FileInputStream(srcFile);
        FileOutputStream fos=new FileOutputStream(destPath);
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        ByteBuffer buffer=ByteBuffer.allocate(1024);
        while (true){
            int flag=inChannel.read(buffer);
            if (flag==-1){
                break;
            }
            buffer.flip();//切换为读模式
            outChannel.write(buffer);//写出
            buffer.flip();//切换为写模式
            buffer.clear();//清空缓冲区
        }

    }
}
