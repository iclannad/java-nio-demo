package org.example.select;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        // Java传统socket编程
        try (Socket socket = new Socket("127.0.0.1", 8080);
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("已连接到服务器");
            OutputStream stream = socket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(stream);
            System.out.println("请输入要发给服务器的内容：");
            String text = scanner.nextLine();
            writer.write(text + "\n");
            writer.flush();
            System.out.println("数据已发送:" + text);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("收到服务端返回：" + reader.readLine());
        } catch (IOException e) {
            System.out.println("服务端连接失败");
            e.printStackTrace();
        } finally {
            System.out.println("客户端断开连接!");
        }
    }
}
