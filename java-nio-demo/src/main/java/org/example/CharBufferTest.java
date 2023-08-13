package org.example;

import java.nio.CharBuffer;

public class CharBufferTest {

    public static void main(String[] args) {
//        CharBuffer buffer = CharBuffer.wrap("yokohama");
//        // java.nio.ReadOnlyBufferException
////        buffer.put(0,'q');  // 只读buffer
//        while (buffer.hasRemaining()) {
//            System.out.print(buffer.get());
//        }


        CharBuffer buffer = CharBuffer.allocate(10);
        buffer.put("yokohama");
        buffer.append("-");
        buffer.flip();
        // 重写charbuffer toString
        System.out.println(buffer.toString());
    }

}
