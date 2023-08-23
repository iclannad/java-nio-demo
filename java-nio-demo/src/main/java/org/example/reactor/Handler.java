package org.example.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

// 处理读写事件
public class Handler implements Runnable {

    private final SocketChannel channel;

    public Handler(SocketChannel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(128);
            channel.read(buffer);
            buffer.flip();
            System.out.println("Received data from client：" + new String(buffer.array(), 0, buffer.remaining()));
            channel.write(ByteBuffer.wrap("OK!".getBytes()));
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
