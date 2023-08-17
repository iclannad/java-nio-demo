package org.example.select;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        // Java传统socket编程
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("等待客户端连接...");
            Socket socket = server.accept();
            System.out.println("客户端已连接，IP地址为：" + socket.getInetAddress().getHostAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.print("收到客户端数据：");
            System.out.println(reader.readLine());

            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("已收到!");
            writer.flush();
            writer.close();
            System.out.println("服务端执行完成");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
