package org.example.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class ChannelTest {
    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        ReadableByteChannel channel = Channels.newChannel(System.in);
        while (true) {
            // 将通道的数据读到缓存区
            channel.read(buffer);
            // buffer写完，进行翻转
            buffer.flip();
            // 打印读取的数据
            System.out.println(new String(buffer.array(),0,buffer.remaining()));
            // 清除数据
            buffer.clear();
        }
    }
}
