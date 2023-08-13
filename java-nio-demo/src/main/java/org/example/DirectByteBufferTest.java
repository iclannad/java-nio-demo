package org.example;

import java.nio.ByteBuffer;

public class DirectByteBufferTest {

    public static void main(String[] args) {
        // 直接缓存区,堆外内存
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);

        // 使用方式和之前一样
        buffer.put((byte) 66);
        buffer.flip();
        System.out.println(buffer.get());

    }
}
