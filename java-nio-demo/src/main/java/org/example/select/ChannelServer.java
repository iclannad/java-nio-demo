package org.example.select;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ChannelServer {

    public static void main(String[] args) {
        // Channel socket编程
        // 创建ServerSocketChannel
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            // 绑定端口
            serverSocketChannel.bind(new InetSocketAddress(9090));

            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("IP:" + socketChannel.getRemoteAddress());

            ByteBuffer byteBuffer = ByteBuffer.allocate(256);
            socketChannel.read(byteBuffer);
            byteBuffer.flip();
            System.out.println("Receive data from client:" + new String(byteBuffer.array(),0,byteBuffer.remaining()));

            socketChannel.write(ByteBuffer.wrap("OK!".getBytes()));

            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
