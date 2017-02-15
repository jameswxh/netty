package com.hzmsc.scada.Equipment.codec;

import com.hzmsc.scada.Equipment.model.JmtisMsg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by wxhx1 on 2017/2/8.
 */
public class JmtisBodyEncoder extends MessageToByteEncoder<JmtisMsg> {

    @Override
    protected void encode(ChannelHandlerContext ctx, JmtisMsg msg, ByteBuf out) throws Exception {
        out.writeLong(msg.getSendTime());
    }
}
