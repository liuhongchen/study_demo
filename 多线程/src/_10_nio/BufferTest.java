package _10_nio;

import org.junit.Test;

import java.nio.ByteBuffer;

public class BufferTest {


    @Test
    public void test(){
        ByteBuffer buffer=ByteBuffer.allocate(10);
//        System.out.println(buffer.position());
//        System.out.println(buffer.limit());
//        System.out.println(buffer.capacity());


        String name="Hansing";
        buffer.put(name.getBytes());
        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());

        //第一次读取，两个字符 得到Ha
        byte[] bytes=new byte[2];
        buffer.get(bytes);
        buffer.mark();//标记position的位置到2
        System.out.println(new String(bytes));

        //第二次读取，得到两个字符ns
        bytes=new byte[2];
        buffer.get(bytes);
        System.out.println(new String(bytes));

        buffer.reset();// reset，将position置为mark标记的2
        bytes=new byte[2];//再度，就还是从2开始读，得到ns
        buffer.get(bytes);
        System.out.println(new String(bytes));
    }
}
