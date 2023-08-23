package org.example.reactor;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

// 处理客户端连接
public class Acceptor implements Runnable {

    private final ServerSocketChannel serverChannel;
    private final Selector selector;

    public Acceptor(ServerSocketChannel serverChannel, Selector selector) {
        this.serverChannel = serverChannel;
        this.selector = selector;
    }


    @Override
    public void run() {
        try {
            SocketChannel channel = serverChannel.accept();
            System.out.println("New client，IP：" + channel.getRemoteAddress());
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_READ, new Handler(channel));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
