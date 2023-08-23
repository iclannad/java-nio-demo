package org.example.select;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class SelectChannelServer {

    public static void main(String[] args) {
        // 初级reator网络编程模型,bio:每个socket都需要一个线程来读写数据。如果客户端增大，会极大消耗服务端资源,因此引出nio模型
        // 创建ServerSocketChannel
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open(); Selector selector = Selector.open()) {
            // 绑定端口
            serverSocketChannel.bind(new InetSocketAddress(9090));
            serverSocketChannel.configureBlocking(false);

            // 往select注册事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                int count = selector.select();
                System.out.println("listen event count:" + count);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    // 新的连接socket事件
                    if (key.isAcceptable()) {
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        System.out.println("New client, IP:" + socketChannel.getRemoteAddress());
                        socketChannel.configureBlocking(false);
                        // 将socket注册到select中
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        // socket读事件
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
                        socketChannel.read(byteBuffer);
                        byteBuffer.flip();
                        System.out.println("Receive Data from client:" + new String(byteBuffer.array(), 0, byteBuffer.remaining()));
                        byteBuffer.clear();
                        socketChannel.write(ByteBuffer.wrap("OK!".getBytes()));
                        socketChannel.close();
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
