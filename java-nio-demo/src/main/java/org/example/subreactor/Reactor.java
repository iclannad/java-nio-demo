package org.example.subreactor;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

// 主reactor
public class Reactor implements Closeable, Runnable {
    private final ServerSocketChannel serverSocketChannel;
    private final Selector selector;

    public Reactor() throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        selector = Selector.open();
    }

    @Override
    public void close() throws IOException {
        serverSocketChannel.close();
        selector.close();
    }

    @Override
    public void run() {
        try {
            serverSocketChannel.bind(new InetSocketAddress(9090));
            serverSocketChannel.configureBlocking(false);
            // 往select注册事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT, new Acceptor(serverSocketChannel));
            while (true) {
                int count = selector.select();
                System.out.println("listen event count:" + count);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    this.dispatch(key);
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void dispatch(SelectionKey key) {
        Object att = key.attachment();
        if (att instanceof Runnable) {
            ((Runnable) att).run();
        }
    }
}


