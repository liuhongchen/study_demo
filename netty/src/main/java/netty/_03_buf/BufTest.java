package netty._03_buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

public class BufTest {

    public static void main(String[] args) {

//        /*
//         * 1. 创建对象，对象包含一个byte数组，是一个byte[10]
//         * 2. 在netty的buffer中，不需要使用flip
//         * 3. 底层维护了readerIndex和writerIndex，
//         *      可读范围是[readIndex,writerIndex)
//         *      可写范围是[writerIndex,capacity)
//         */
//        ByteBuf byteBuf= Unpooled.buffer(10);
//
//        for (int i = 0; i < 10; i++) {
//            byteBuf.writeByte(i);
//        }
//
//        for (int i = 0; i < 10; i++) {
//            //这个只是读，不会修改readerIndex
//            System.out.println(byteBuf.getByte(i));
//        }
//
//        for (int i = 0; i < 10; i++) {
//            //这个会修改readerIndex
//            System.out.println(byteBuf.readByte());
//        }


        ByteBuf byteBuf
                = Unpooled.copiedBuffer("helloworld", CharsetUtil.UTF_8);

        if (byteBuf.hasArray()){
            byte[] content = byteBuf.array();
            System.out.println(new String(content));

            //输出结果：UnpooledByteBufAllocator
            //  $InstrumentedUnpooledUnsafeHeapByteBuf(ridx: 0, widx: 10, cap: 30)
            // 是Unpooled 的内部类
            System.out.println(byteBuf);

            //返回可读取的数量
            int length = byteBuf.readableBytes();


        }


    }
}
