package org.example.subreactor;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


// 从reactor
public class SubReactor implements Closeable, Runnable {
    private final Selector selector;
    private static final ExecutorService POOL = Executors.newFixedThreadPool(10);
    private static final SubReactor[] reactors = new SubReactor[10];
    private static int selectedIndex = 0;

    // 启动10个select处理socket read事件
    static {
        for (int i = 0; i < 4; i++) {
            try {
                reactors[i] = new SubReactor();
                POOL.submit(reactors[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Get next selector
    public static Selector nextSelector() {
        Selector selector = reactors[selectedIndex].selector;
        selectedIndex = (selectedIndex + 1) % 10;
        return selector;
    }


    public SubReactor() throws IOException {
        selector = Selector.open();
    }

    @Override
    public void close() throws IOException {
        selector.close();
    }

    @Override
    public void run() {
        try {
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


