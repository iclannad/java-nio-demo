package org.example.netty;

import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Promise;

import java.util.concurrent.ExecutionException;

public class PromiseDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Promise<String> promise = new DefaultPromise<>(new DefaultEventLoop());
        System.out.println(promise.isSuccess());  // false
        promise.setSuccess("Done successfully");    //set success value
        System.out.println(promise.isSuccess());
        System.out.println(promise.get());    //get result
    }
}
