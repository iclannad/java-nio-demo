package org.example.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

    public static void main(String[] args) throws IOException {
        // 基础文件输入和输出流demo，单向
//        try (FileOutputStream fos = new FileOutputStream("test.txt");
//             FileInputStream fis = new FileInputStream("test.txt")) {
//            String data = "This is my data";
//            fos.write(data.getBytes());
//            fos.flush();
//
//            byte[] bytes = new byte[fis.available()];
//            fis.read(bytes);
//            System.out.println(new String(bytes));
//        }

        // fileChannel是双向的: 通过输入流和输出流获取对应的通道
//        FileInputStream fis = new FileInputStream("test.txt");
//        FileChannel fileChannel = fis.getChannel();
//
//        ByteBuffer buffer = ByteBuffer.allocate(128);
//        fileChannel.read(buffer);
//        buffer.flip();
//        System.out.println(new String(buffer.array(),0,buffer.remaining()));

        // 若将输入流作为源的通道写入数据，将会报错,NonWritableChannelException
//        fileChannel.write(ByteBuffer.wrap("test".getBytes()));

        // 若将输出流作为源的通道读数据，将会报错  NonReadableChannelException
//        FileOutputStream fos = new FileOutputStream("test2");
//        FileChannel fosChannel = fos.getChannel();
//        ByteBuffer buffer = ByteBuffer.allocate(128);
//        fosChannel.read(buffer);
//        buffer.flip();
//        System.out.println(new String(buffer.array(), 0, buffer.remaining()));


        // 可读可写
//        try (RandomAccessFile f = new RandomAccessFile("test", "rw");
//             FileChannel channel = f.getChannel()) {
//            channel.write(ByteBuffer.wrap("test33333333333333333".getBytes()));
//            channel.position(0);
//
//            ByteBuffer buffer = ByteBuffer.allocate(128);
//            channel.read(buffer);
//            buffer.flip();
//            System.out.println(new String(buffer.array(), 0, buffer.remaining()));
//        }


        // fileChannel通道的数据写到另一个通道
        try (FileOutputStream fos = new FileOutputStream("test3");
             FileInputStream fis = new FileInputStream("test")) {

            FileChannel fisChannel = fis.getChannel();
            fisChannel.transferTo(0, fisChannel.size(), fos.getChannel());
        }


    }
}
