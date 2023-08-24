package org.example.subreactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 处理读写事件
public class Handler implements Runnable {

    private static final ExecutorService POOL = Executors.newFixedThreadPool(20);

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
            // 使用线程池读取数据
            POOL.submit(() -> {
                try {
                    System.out.println("Received data from client：" + new String(buffer.array(), 0, buffer.remaining()));
                    channel.write(ByteBuffer.wrap("OK!".getBytes()));
//                    channel.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
