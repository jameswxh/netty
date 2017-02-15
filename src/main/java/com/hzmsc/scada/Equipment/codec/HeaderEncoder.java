package com.hzmsc.scada.Equipment.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * Created by wxhx1 on 2017/2/8.
 */
public class HeaderEncoder extends MessageToMessageEncoder<ByteBuf> {
    @Override
    protected void encode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        ByteBuf header = ctx.alloc().buffer(8);
        header.writeInt(0x1111);
        header.writeInt(msg.readableBytes());
        System.out.println(ByteBufUtil.hexDump(header));
        System.out.println(ByteBufUtil.hexDump(msg));
        out.add(header);
        out.add(msg.retain());
    }
}
