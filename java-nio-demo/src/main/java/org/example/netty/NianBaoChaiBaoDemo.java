package org.example.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.nio.charset.StandardCharsets;

public class NianBaoChaiBaoDemo {
    public static void main(String[] args) {
        // 主reactor：负责处理socket accept事件
        // 从reator： 负责处理socket read事件
        EventLoopGroup bossGroup = new NioEventLoopGroup(), workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel channel) {
                        // 1、定长解析
//                        channel.pipeline()
//                                .addLast(new FixedLengthFrameDecoder(10))
//                                .addLast(new ChannelInboundHandlerAdapter() {
//                                    @Override
//                                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//                                        ByteBuf buf = (ByteBuf) msg;
//                                        System.out.println(buf.toString(StandardCharsets.UTF_8));
//                                    }
//                                });

                        // 2、特定的分隔符
//                        channel.pipeline()
//                                .addLast(new DelimiterBasedFrameDecoder(1024, Unpooled.wrappedBuffer("!".getBytes())))
//                                .addLast(new ChannelInboundHandlerAdapter() {
//                                    @Override
//                                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//                                        ByteBuf buf = (ByteBuf) msg;
//                                        System.out.println(buf.toString(StandardCharsets.UTF_8));
//                                    }
//                                });


                    }
                });
        bootstrap.bind(9090);


    }
}
