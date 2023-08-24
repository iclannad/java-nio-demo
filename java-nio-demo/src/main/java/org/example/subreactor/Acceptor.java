package org.example.subreactor;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

// 处理客户端连接事件
public class Acceptor implements Runnable {

    private final ServerSocketChannel serverChannel;

    public Acceptor(ServerSocketChannel serverChannel) {
        this.serverChannel = serverChannel;
    }


    @Override
    public void run() {
        try {
            SocketChannel channel = serverChannel.accept();
            System.out.println(Thread.currentThread().getName() + "New client，IP：" + channel.getRemoteAddress());
            channel.configureBlocking(false);
            // Get next selector
            Selector selector = SubReactor.nextSelector();
            selector.wakeup();
            // 将read事件注册到selector中，由单独的select处理
            channel.register(selector, SelectionKey.OP_READ, new Handler(channel));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
