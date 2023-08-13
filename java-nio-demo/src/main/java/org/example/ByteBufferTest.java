package org.example;

import java.nio.ByteBuffer;

public class ByteBufferTest {

    public static void main(String[] args) {
        ByteBuffer buffer= ByteBuffer.allocate(10);
        // 除了直接丢byte进去之外，也可以直接丢其它的基本类型
        buffer.putInt(Integer.MAX_VALUE);
        System.out.println(buffer.remaining());

        buffer.flip();
        // 以单个字节形式读取
//        while (buffer.hasRemaining()) {
//            System.out.println(buffer.get());
//        }

        // 以4字节形式读取,int类型
        System.out.println(buffer.getInt());

    }
}
