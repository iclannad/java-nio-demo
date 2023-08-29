package org.example.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.nio.charset.StandardCharsets;
import java.util.List;

// 自定义解码器
public class MyTestDecoder extends MessageToMessageDecoder<ByteBuf> {


    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        String text = byteBuf.toString(StandardCharsets.UTF_8);
        // 处理应用层数据包,可处理粘包合拆包问题
        list.add(text + "-1");
        list.add(text + "-2");
    }
}
