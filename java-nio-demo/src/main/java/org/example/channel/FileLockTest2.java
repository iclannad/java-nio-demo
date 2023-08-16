package org.example.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Date;

public class FileLockTest2 {

    public static void main(String[] args) throws IOException,InterruptedException {

        RandomAccessFile f = new RandomAccessFile("test", "rw");
        FileChannel channel = f.getChannel();

        System.out.println(new Date() + " 正在获取锁...");
        // 独立锁
        FileLock fileLock = channel.lock(0, 6, false);
        // 共享锁
//        FileLock fileLock = channel.lock(0, 6, true);
        System.out.println(new Date() + " 已获取到锁...");
        Thread.sleep(10000);
        System.out.println(new Date() + " 释放锁...");
        fileLock.release();


    }
}
