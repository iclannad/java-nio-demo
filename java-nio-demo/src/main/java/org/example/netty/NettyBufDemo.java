package org.example.netty;

import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

public class NettyBufDemo {


    public static void main(String[] args) {

//        ByteBuf buf = Unpooled.buffer(10);
//        System.out.println("Init status:" + Arrays.toString(buf.array()));
//
//        // 一次性写4个字节数据
//        buf.writeInt(-888888888);
//        System.out.println("Write Int data:" + Arrays.toString(buf.array()));
//
//        buf.readShort();
//        System.out.println("Read short data:" + Arrays.toString(buf.array()));
//
//
//        buf.discardReadBytes();
//        System.out.println("After discard data:" + Arrays.toString(buf.array()));
//
//        buf.clear();
//        System.out.println("After clear data:" + Arrays.toString(buf.array()));

//        System.out.println("-------------------------------------------------");
//        ByteBuf buf = Unpooled.wrappedBuffer("abcdefg".getBytes());
//        System.out.println(Arrays.toString(buf.array()));
//        // read 1 byte data
//        buf.readByte();
//        ByteBuf slice = buf.slice();
//
//        System.out.println(slice.arrayOffset());
//        System.out.println(Arrays.toString(slice.array()));
//        System.out.println(slice.readByte());

//        System.out.println("-------------------------------------------------");
//        ByteBuf buf = Unpooled.buffer(10);  // 自动动态扩容
////        ByteBuf buf = Unpooled.buffer(10, 10);  // 不允许动态扩容
//        System.out.println(buf.capacity());
//        System.out.println(Arrays.toString(buf.array()));
//
//        buf.writeCharSequence("This isssssssssssssssssssssssssssss test", StandardCharsets.UTF_8);
//        System.out.println(buf.capacity());
//        System.out.println(Arrays.toString(buf.array()));

        // 直接缓存区,底层非java数组
//        ByteBuf buf = Unpooled.directBuffer(10);
//        System.out.println(Arrays.toString(buf.array()));


        // 复合缓冲区，从视图上看是一个缓存区
        CompositeByteBuf buf = Unpooled.compositeBuffer();
        buf.addComponent(Unpooled.copiedBuffer("abc".getBytes()));
        buf.addComponent(Unpooled.copiedBuffer("def".getBytes()));

        for (int i = 0; i < buf.capacity(); i++) {
            System.out.println((char) buf.getByte(i));
        }

    }

}
